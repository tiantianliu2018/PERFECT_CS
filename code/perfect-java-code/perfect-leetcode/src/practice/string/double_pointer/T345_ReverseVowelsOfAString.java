package practice.string.double_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kelly
 * @create 2020-09-12 16:42
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class T345_ReverseVowelsOfAString {
    // 双指针，一个从头开始搜，一个从尾开始搜，两个位置都搜到元音，交换位置
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        // 建立一个 set 集合，保存元音
        Set<Character> vowels = new HashSet<>(
            Arrays.asList( 'A','a','E','e','I','i','O','o','U','u'));
        int left = 0, right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(charArray[left])) left++;
            while (right > left && !vowels.contains(charArray[right])) right--;
            // 交换位置
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
