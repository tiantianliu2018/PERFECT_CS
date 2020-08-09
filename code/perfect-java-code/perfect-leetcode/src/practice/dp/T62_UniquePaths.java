package practice.dp;

/**
 * @author Kelly
 * @create 2020-07-24 23:25
 */
public class T62_UniquePaths {
    /**
     * 一维动规
     */
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) return 1;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (i == 0 && j == 0) dp[j] = 1;
               else if (j == 0) dp[j] = dp[j];
               else dp[j] += dp[j-1];
            }
        }
        return dp[n - 1];
    }
    /**
     * 动态规划  二维
     * 状态定义：dp[i][j] 表示到达 [i,j] 不同的路径数
     * 状态转移：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * base case:
     *      dp[0][j] = 1;
     *      dp[i][0] = 1;
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
