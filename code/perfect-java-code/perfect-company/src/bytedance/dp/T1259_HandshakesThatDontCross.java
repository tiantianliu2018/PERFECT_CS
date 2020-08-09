package bytedance.dp;

/**
 * @author Kelly
 * @create 2020-07-25 14:29
 */
public class T1259_HandshakesThatDontCross {
    /**
     * 动态规划
     * 定义状态 dp[i] 表示已经有 i 对握手的情况下，握手的方案数
     *
     */
    public int numberOfWays(int num_people) {
        if (num_people == 2) return 1;
        long[] dp = new long[num_people + 1];
        for (int i = 2; i <= num_people; i += 2) {
            dp[i] = 0;
            for (int j = 1; j < i; j += 2) {
                dp[i] = (dp[i] + (dp[j - 1] * dp[i - j - 1]) % 1000000007) %1000000007;
            }
        }
        return (int) dp[num_people];
    }
}
