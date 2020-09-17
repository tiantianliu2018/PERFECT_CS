package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-17 09:52
 */
public class T188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        if (n / 2 <= k) {  // 退化为无限次交易
            return greedySearch(prices);
        }
        // k 次交易的限制
        int[][][] dp = new int[n][k + 1][2];
        // base case
        for (int t = 0; t <= k; t++) {
            dp[0][t][1] = -prices[0];
        }
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
                } else {
                    // 原来就不持有股票，或者原来持有但是现在卖出了
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
                    // 原来就持有股票，或者原来不持有，但是买入了
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
                }
            }
        }
        return dp[n-1][k][0];
    }
    // 贪心搜索无限次交易可以获得的最大利润
    private int greedySearch(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(prices[i] - prices[i-1], 0);
        }
        return maxProfit;
    }


    // 由于状态转移仅仅和前一天相关，因此可以进行状态压缩
    public int maxProfit1(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        if (k >= n / 2) return greedySearch(prices);
        int[][] dp = new int[k + 1][2];
        // base case
        for (int i = 0; i <= k; i++) {
            dp[i][1] = -prices[0];
        }
        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[j][0] = 0;
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
                } else {
                    dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
                }
            }
        }
        return dp[k][0];
    }
}
