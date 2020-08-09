package practice.dp;

/**
 * @author Kelly
 * @create 2020-07-28 19:48
 */
public class T1230_TossStrangeCoins {
    /**
     * 动态规划
     *      dp[i][j] 表示扔 i 枚硬币，有 j 枚朝上的概率
     * 状态转移：
     *      dp[i][j] = dp[i-1][j-1] * prob[i] +  dp[i-1][j] * (1-prob[i])
     *      第 i 枚朝上，i-1 枚 j-1 枚朝上 或者 第 i 枚朝下，前 i-1 枚，有 j 枚朝上
     * base case:  dp[i][0] = dp[i-1][0] * (1-prob[i])
     */
    public double probabilityOfHeads(double[] prob, int target) {
        if (prob == null || prob.length == 0) return 0;
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i -1]);
            }
        }
        return dp[n][target];
    }
}
