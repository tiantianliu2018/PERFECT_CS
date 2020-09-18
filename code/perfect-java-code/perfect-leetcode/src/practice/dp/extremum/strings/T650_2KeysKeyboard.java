package practice.dp.extremum.strings;

/**
 * @author Kelly
 * @create 2020-09-18 10:50
 */
public class T650_2KeysKeyboard {
    /**
     * 定义状态： dp[i] 表示要得到 i 个 A，最少需要的操作次数
     * 若一个数是素数，那么只能通过复制一个 A，然后一步一步粘贴得到
     * 若不是负数，可以通过对该数分解因数，通过其因子数得到
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;  // 赋初值
            // 判断当前数是否有因子，若有直接更新为: 形成因子的操作次数 + 因子变成当前数的操作
            for (int j = 2; j <= m; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i/j];
                }
            }
        }
        return dp[n];
    }
}
