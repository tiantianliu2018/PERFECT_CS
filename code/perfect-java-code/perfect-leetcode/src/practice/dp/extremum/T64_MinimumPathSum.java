package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-13 16:25
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class T64_MinimumPathSum {
    /**
     * 状态定义：dp[i][j] 表示走到了 i 行第 j 列的最小路径
     * 状态转移：dp[i][j] = min(dp[i-1][j], dp[i][j-1] + grid[i][j]
     * base case:
     *      dp[0][j] = dp[0][j-1] + grid[0][j]
     *      dp[i][0] = dp[i-1][0] + grid[i][0]
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n ; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 由于当前 dp[i][j] 只可能从上或者左边转移过来，因此可以进行状态压缩
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[j] = grid[0][0];
                else if (j == 0) {  // 最左侧的一列，只能从上边转移过来
                    dp[j] = dp[j] + grid[i][0];
                } else if (i == 0) {  // 最上面一行，只能从左边转移过来
                    dp[j] = dp[j - 1] + grid[0][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

}
