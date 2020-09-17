package practice.string.double_pointer;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-12 17:18
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。
 * 如果答案不存在，则返回空字符串。
 *
 */
public class T524_LongestWordInDictionaryThroughDeleting {
    /**
     *
     */
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        for (String word : d) {
            if (isSubString(word, s)) {
                // 当前 word 大于 res，或者字典序更小
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }

    /**
     * 判断 word 是否是 s 的子串
     * 通过双指针来判断
     */
    private boolean isSubString(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
