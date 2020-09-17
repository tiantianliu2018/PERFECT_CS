package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-17 09:24
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。s
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 */
public class T123_BestTimeToBuyAndSellStockIII {
    /**
     * 定义状态：
     *      dp[i][k][0] 第 i 天完成交易次数是 k，不持有股票的状态下可以获得的最大利润
     *      dp[i][k][1] 第 i 天完成交易次数是 k，持有股票的状态下可以获得的最大利润
     * 状态转移：
     *      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[i])  // 卖出时算作一次完整交易
     *      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     *      由于本题交易次数限制为 2，可以展开来写
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        // base case
        for (int k = 0; k < 2; k++) {
            // dp[0][k][0] = 0, 初值本身为 0，不用特殊赋值
            dp[0][k][1] = -prices[0];
        }
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 交易 0 次，持有股票，原来就持有股票，或者原来没有股票但是买入了
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
            // 交易 1 次，不持有股票：原来没有股票，或者原来持有股票但是卖出了，算作一次完整交易
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0] - prices[i]);
            // 交易 2 次
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][2][0] - prices[i]);
        }
        return dp[n-1][2][0];
    }
}
