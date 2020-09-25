package practice.greedy;

/**
 * @author Kelly
 * @create 2020-09-25 09:39
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class T122_BestTimeToBuyAndSellStockII {
    /**
     * 在低点买入，高点卖出，就一定可以获利
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit += prices[i] - minPrice;
            }
            minPrice = prices[i];
        }
        return maxProfit;
    }

    /**
     * 只要后一天比前一天高，就在前一天买入，后一天卖出，获得收益，否则不动
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
