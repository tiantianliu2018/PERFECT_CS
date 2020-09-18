package practice.dp.extremum.strings;

/**
 * @author Kelly
 * @create 2020-09-18 10:15
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 *   插入一个字符
 *   删除一个字符
 *   替换一个字符
 */
public class T72_EditDistance {
    /**
     * 定义状态：dp[i][j] 表示将 word1 前 i 个字符转成 word2 前 j 个字符所需要的最少操作次数
     * 状态转移：
     *      dp[i][j] = dp[i-1][j-1]，if word1[i] = word2[j]
     *      dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1  分别表示 替换、删除、插入
     * base case:
     *      dp[0][0] = 0;
     *      dp[0][j] = j;
     *      dp[i][0] = i;
     */
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m ; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
