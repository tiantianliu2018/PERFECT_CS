package practice.dp.bag;

/**
 * @author Kelly
 * @create 2020-09-16 09:53
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class T518_CoinChange2 {
    // dp[i] 表示可以组成金额 i 的组合总数
    public int change(int amount, int[] coins) {
        if (coins == null) return 0;
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
