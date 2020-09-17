package practice.dp.bag;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-16 09:09
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class T322_CoinChange {
    /**
     * 由于每种面额的硬币数没有限制，可以看做一个 完全 背包问题
     * 定义状态：
     *      dp[i] 表示硬币可以组成面额 i 需要的最少硬币的个数
     * 状态转移：dp[i] = min(dp[i], dp[i-coins[j] + 1]
     *
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        // 将 dp 数组填充为一个不可能的取值，便于判断最后是否可以组成一定金额
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 对于每一种硬币
        for (int coin : coins) {
            // 对于每一种可以组成的金额
            for (int i = coin; i <= amount; i++) {
                if (i == coin) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int res = coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }
}
