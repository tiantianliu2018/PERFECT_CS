package practice.string;

/**
 * @description 最长回文子串
 * @author Kelly
 * @create 2021-06-20 11:31
 */

import java.security.acl.AclEntry;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 1. 暴力法
 * 2. 动态规划
 * 3. 中心扩散
 */
public class T5_LongestPalindromicSubstring {
    /**
     * 中心扩散法
     *
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // (i,i) 或 (i,i+1) 作为扩散中心
            String s1 = centerSpread(s, i, i);
            String s2 = centerSpread(s, i, i + 1);
            String currMaxLenSubStr = (s1.length() > s2.length()) ? s1 : s2;
            result = (currMaxLenSubStr.length() > result.length()) ? currMaxLenSubStr : result;
        }
        return result;
    }

    /**
     * 从中心往两边扩散，寻找最长的子串
     *
     * @param s 输入字符串
     * @param left 左边界
     * @param right 右边界
     * @return 最长回文串
     */
    private String centerSpread(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    /**
     * 动态规划 如果 s[i,j] 是回文串，且 s[i-1] == s[j+1] 那么 s[i-1, j+1] 也是回文串
     * 二维动规：
     * 状态定义：dp[i][j] 表示子串 s[i,j] 是否是回文串
     * 状态初始化：dp[i][j] = true if (i == j)
     * 状态转移：dp[i][j] = dp[i+1][j-1] 回文 && s[i] == s[j]
     *
     * @param s 输入参数
     * @return 最长回文子串
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        String result = s.substring(0, 1);
        // 动态规划，更新最长回文子串
        for (int j = 1; j < n; j++) {  // 右侧指针
            for (int i = 0; i < j; i++) {  // 左侧指针
                if (s.charAt(i) == s.charAt(j)) {
                    // 子串包含的字符数小于等于 3 个，在该条件下一定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                // 更新最长回文子串的结果
                if (dp[i][j]) {
                    String currStr = s.substring(i, j + 1);
                    result = (currStr.length() > result.length()) ? currStr : result;
                }
            }
        }
        return result;
    }

    /**
     * 暴力法，双层循环找子串，内存函数判断是否是回文串，总的时间复杂度 O(n^3)
     *
     * @param s 参数
     * @return 最长的回文子串
     */
    public String longestPalindrome2(String s) {
        // 入参判断
        if (s == null || s.length() < 2) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr)) {
                    result = (subStr.length() > result.length()) ? subStr : result;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
