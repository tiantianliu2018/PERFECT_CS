package practice.dp.bag;

/**
 * @author Kelly
 * @create 2020-09-14 20:01
 *
 * 假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 */
public class T474_OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || (m == 0 && n == 0)) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            // 分别得到 0 和 1 的个数
            int zeros = findZeroAndOne(strs[i-1])[0];
            int ones = findZeroAndOne(strs[i-1])[1];
            for (int j = m; j >= zeros ; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] findZeroAndOne(String str) {
        int num0 = 0, num1 = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') num0++;
            else if (c == '1') num1++;
        }
        return new int[]{num0, num1};
    }
}
