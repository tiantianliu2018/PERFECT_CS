package practice.greedy;

/**
 * @author Kelly
 * @create 2020-09-25 09:30
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 */
public class T121_BestTimeToBuyAndSellStock {
    /**
     * 贪心算法，记录一个最小值，在前面看过的最低点买入，高于最低点卖出，迭代更新
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
