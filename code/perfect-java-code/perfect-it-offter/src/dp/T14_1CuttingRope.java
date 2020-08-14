package dp;

/**
 * @author Kelly
 * @create 2020-08-11 19:30
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 */
public class T14_1CuttingRope {
    /**
     * 动态规划
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 将 [1,i] 进行拆分为两个部分，然后看 （i-j）能否继续进行拆分
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 数学，尽量拆分为 3 相乘
     */
    public int cuttingRope1(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        if (n % 3 == 1) return (int) Math.pow(3, n / 3 - 1) * 4;
        return (int) Math.pow(3, n / 3) * 2;
    }
}
