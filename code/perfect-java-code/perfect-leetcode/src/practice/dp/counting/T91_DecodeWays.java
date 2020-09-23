package practice.dp.counting;

/**
 * @author Kelly
 * @create 2020-09-22 10:28
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class T91_DecodeWays {
    /**
     * 动态规划：dp[i] 表示前 i 个字符的解码方法数
     * 状态转移：
     *      dp[i] = dp[i-1] + dp[i-2]  末尾的数字单独解码 or 末尾的两个数字可以组成一个字母，一起解码
     *
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 前 0 个字符只有一种解码方式，
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {  // 最后一个字符不是 0，可以单独解码
                dp[i] += dp[i-1];
            }
            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {  // 最后两个字符可以一起解码
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

}
