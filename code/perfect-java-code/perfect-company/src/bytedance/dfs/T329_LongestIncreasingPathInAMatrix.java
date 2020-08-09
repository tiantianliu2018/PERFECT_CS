package bytedance.dfs;

/**
 * @author Kelly
 * @create 2020-07-25 12:33
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * DFS + 记忆化搜索
 */
public class T329_LongestIncreasingPathInAMatrix {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        // 缓存最长路径的长度
        int[][] len = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, len, i, j));
            }
        }
        return res;
    }
    // DFS 搜索每一个位置的最长路径
    private int dfs(int[][] matrix, int[][] len, int i, int j) {
        if (len[i][j] != 0) return len[i][j];
        len[i][j] = 1;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] <= matrix[i][j]) continue;
            len[i][j] = Math.max(len[i][j], dfs(matrix, len, newX, newY) + 1);
        }
        return len[i][j];
    }
}
