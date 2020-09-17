package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-16 12:41
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class T309_BestTimeToBuyAndSellStockWithCooldown {
    /**
     * 股票的状态有：买入、卖出和冷冻期
     * 定义状态：dp[i][0] 不持有股票，dp[i][1] 持有股票，dp[i][2] 冷冻期
     * 状态转移：
     *      dp[i][0] = max(dp[i-1][2], dp[i-1][0])  从冷冻期转移过来或者是一直不持有股票
     *      dp[i][1] = max(dp[i-1][0] - prices[i], dp[i][1])  前一天不持有股票，今天买入了或者原本就持有股票
     *      dp[i][2] = dp[i-1][1] + prices[i] 前一天持有股票但是卖出了，进入冷冻期
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][3];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][2], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i-1], dp[i-1][1]);
            dp[i][2] = dp[i-1][1] + prices[i-1];
        }
        return Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    }
}
