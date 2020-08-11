package backtrack;

/**
 * @author Kelly
 * @create 2020-08-11 09:55
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 */
public class T12_WordSearch {
    int n, m;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        n = board.length;
        m = board[0].length;
        // 可以从任意一格开始
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (backtracking(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, boolean[][] visited, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        // 回溯标记
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (backtracking(board, word, newX, newY, visited, idx + 1)) return true;
        }
        // 释放选择
        visited[i][j] = false;
        return false;
    }
}
