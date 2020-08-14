package dp;

/**
 * 请实现一个函数用来匹配包含 '. '和 '*'的正则表达式。
 * 模式中的字符 '.'表示任意一个字符，
 * 而 '*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串 "aaa"与模式 "a.a"和 "ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class T19_RegularExpressionMatching {
    /**
     * 动态规划
     * 定义状态：
     *      dp[i][j] 表示字符串的前 i 个字符和模式的前 j 的字符是否匹配
     * 状态转移：
     *      dp[i][j] = dp[i-1][j-1] if s[i]=p[j] || p[j] = '.' 当 s[i] 和 p[j] 可以匹配的时候，当前结果取决于 s[:i-1] 和 p[:j-1] 是否匹配
     *      当 s[i] 和 p[j] 不匹配的时，if p[j] = '*' 由于 * 可以表示它前面字符任意次，分情况讨论：
     *          假如当前字符可以和 * 前面的字符匹配：* 可以选择匹配 0、1 或多次
     *               * 表示其前面的字符 0 次，dp[i][j] = dp[i][j-2]
     *               * 表示其前面的字符 1 次，dp[i][j] = dp[i][j-1]
     *               * 表示其前面的字符多次，则 dp[i][j] = dp[i-1][j]
     *          假如当前字符和 * 前面的字符不匹配：模式直接跳过 * 以及其之前的字符
     * 初始状态：
     *      dp[0][0] = true
     *      dp[0][j] = (dp[0][j-1] && s[j] = '*')
     *      dp[i][0] = false;
     */
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) return true;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // base case
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j-2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // 当前字符和 * 前面的字符匹配，那么 * 可以选择匹配 * 前的字符 0 个， 1 个 或者多个
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        // 0 个，dp[i][j-2]
                        // 1 个，dp[i][j-1]
                        // 多个的话，dp[i-1][j]
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        // 若不匹配，直接舍弃 * 和其前面的字符
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
