package practice.dp.bag;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-16 10:13
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
public class T139_WordBreak {
    /**
     * wordDict 里面取单词组成字符串 s，单词的个数没有限制，可以看成一个完全背包问题
     * 定义状态：
     *      dp[i] 表示字符串的前 i 个字符是否可以由 wordDict 中的单词组成
     * 状态转移：
     *      dp[i] = dp[i] || dp[i-len(word)] 本身前 i 个字符可以由字典中的单词组成，或者前 i-当前单词的长度 是否可以组成
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        // 表示字符串的前 i 个字符是否可以由 wordDict 中的单词组成
        boolean[] dp = new boolean[s.length() + 1];
        // base case dp[0] = true
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                // 当前 word 在 s 中存在
                if (i >= len && s.substring(i-len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[s.length()];
    }
}
