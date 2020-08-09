package practice.dp;

/**
 * @author Kelly
 * @create 2020-07-24 23:36
 */
public class T63_UniquePathsII {
    /**
     * 有障碍物 动态规划
     * 定义状态： dp[i][j] 表示到达 【i,j】 不同的路径
     * 状态转移：
     *      dp[i][j] = dp[i-1][j] + dp[i][j-1]  obstacle[i][j] = 0
     *      dp[i][j] = 0;
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j-1];
                    } else if (j == 0) {
                        dp[i][0] = dp[i-1][0];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
