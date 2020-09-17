package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-13 20:27
 */
public class T343_IntegerBreak {
    /**
     * 状态定义：dp[i] 表示正整数 i 可以拆分成的最大乘积
     * 状态转移，对于 i 可以表示成 j 和 （i-j）的乘积，i-j 可以继续进行拆分或者不拆分
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
    // 数学方法，尽量拆成 3 的倍数
    public int integerBreak1(int n) {
        if (n <= 3) return n - 1;
        if (n % 3 == 0) return (int) Math.pow(3, n/3);
        if (n % 3 == 1) return (int) (Math.pow(3, n/3-1) * 4);
        return (int) (Math.pow(3, n/3)) * 2;
    }
}
