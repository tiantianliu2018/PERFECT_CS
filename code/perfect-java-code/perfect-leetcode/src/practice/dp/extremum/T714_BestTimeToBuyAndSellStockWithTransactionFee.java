package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-17 09:06
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 */
public class T714_BestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * 定义状态：dp[i][0] 第 i 天不持有股票的收益，dp[i][1] 第 i 天持有股票的收益
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 前一天就不持有股票，或者前一天持有股票，但是卖出了，同时扣除手续费
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 前一天就持有股票，或者前一天不持有股票但是买入了
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    /**
     * 状态压缩，每一天的状态只与前一天有关，因此可以进行状态压缩
     */
    public int maxProfit1(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        // 分别表示持有现金（无股票）和持有股票的初始状态
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
