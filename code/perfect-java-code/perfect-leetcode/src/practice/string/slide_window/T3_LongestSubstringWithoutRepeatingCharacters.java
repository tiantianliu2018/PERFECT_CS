package practice.string.slide_window;

/**
 * @author Kelly
 * @create 2021-06-20 10:49
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 [最长子串] 的长度。
 * 滑动窗口：
 * 建立一个 Map（key:num, value:index）
 * 两个指针用来表示在字符串上滑动窗口的边界，滑动最右侧的指针，更新 map 的值
 */
public class T3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 入参校验
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 建立一个 map 用来记录每一个字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;  // 滑动窗口的左边界
        int maxLen = 1;

        // 右边界移动，在字符串上滑动
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 若当前字符已经出现过，则更新左边界，左边界为上一次该字符出现 idx 的下一个位置
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, (right - left + 1));
            map.put(c, right);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
