package practice.string.double_pointer;

/**
 * @author Kelly
 * @create 2020-09-12 16:56
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class T680_ValidPalindromeII {
    /**
     * 回文串既有对称性，双指针，一个指针从左往右，一个指针从右往左
     * 当两个指针指向的字符不相同的时候，可以尝试删除一个字符（可删除左或右），判断剩下的字符是否是回文
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
