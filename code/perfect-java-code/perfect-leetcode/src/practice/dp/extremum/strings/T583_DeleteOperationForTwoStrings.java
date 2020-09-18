package practice.dp.extremum.strings;

/**
 * @author Kelly
 * @create 2020-09-18 09:29
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */
public class T583_DeleteOperationForTwoStrings {
    /**
     * 动态规划
     * 定义状态：dp[i][j] 表示要使 word1 的前 i 个字符和 word2 的前 j 个字符匹配所需要的最小步数
     * 状态转移：
     *      dp[i][j] = dp[i-1][j-1], word1[i] = word2[j]
     *      dp[i][j] = min(dp[i-1][j[, dp[i][j-1]) + 1
     * base case:
     *      dp[0][j] = j
     *      dp[i][0] = i
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null || (word1.equals(word2))) return 0;
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 转换为求两个字符串的最长公共子序列，那么需要删除的字符的个数为：word1 长度 + word2 长度 - 2 * lcs
     * 求最长公共子序列  -- 动态规划
     * 定义状态： dp[i][j] 表示 word1 前 i 个字符和 word2 前 j 个字符的 LCS 的长度
     * 状态转移：
     *      dp[i][j] = dp[i-1][j-1] + 1 if word1[i] = word2[j]
     *      dp[i][j] = max(dp[i-1][j], dp[i][j-1]), if word1[i] != word2[j]
     * base case:
     *      dp[i][0] = 0;  dp[0][j] = 0;
     */
    public int minDistance1(String word1, String word2) {
        if ((word1 == null && word2 == null) || (word1.equals(word2))) return 0;
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n + m - 2 * dp[n][m];
    }
}
