package practice.dfs;

/**
 * @author Kelly
 * @create 2020-08-11 08:11
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class T130_SurroundedRegions {
    public static void main(String[] args) {
        T130_SurroundedRegions solution = new T130_SurroundedRegions();
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution.solve(board);
    }
    /**
     * 1. DFS 遍历，将不变的 ‘O’ 用一个特殊字符替代
     * 2. 将剩下的区域里所有的 'O' 用 'X' 填充
     * 3. 再一次遍历，将特殊字符转为 ‘O’
     * @param board
     */
    int rows, cols;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        // 遍历边界
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i,cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(board,0, j);
            dfs(board, rows - 1, j);
        }
        // 再次遍历，将剩下的‘O’转为‘X’,将特殊字符转为‘O’
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        // 越界或者该位置不是‘O’,直接返回
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') return;
        board[row][col] = 'A';
        // 从边界的某个‘O’出发，可以访问到的‘O’就是不被 X 包围的，不需要进行替换的
        for (int[] direction : directions) {
            int newX = row + direction[0];
            int newY = col + direction[1];
            dfs(board, newX, newY);
        }
    }
}
