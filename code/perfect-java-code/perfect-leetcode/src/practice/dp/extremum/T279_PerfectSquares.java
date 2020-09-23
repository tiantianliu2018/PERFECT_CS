package practice.dp.extremum;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-22 10:07
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 */
public class T279_PerfectSquares {
    /**
     * 动态规划：dp[i] 表示数字 i 完全平方数组成的最少个数
     */
    public int numSquares(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;  // 由 i 个 1 组成
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
