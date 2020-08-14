package practice.string;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class T409_LongestPalindrome {
    /**
     * 首先遍历一遍字符串，得到每个字符的个数，偶数个的直接加，奇数个的取最大放中间，其他可以取偶数个
     */
    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        for (char c : s.toCharArray()) {
            chars[c - 'A']++;
        }
        int res = 0;
        boolean hasOdd = false;
        for (int num : chars) {
            if (num % 2 == 0) res += num;
            else {
                res += num - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) res++;
        return res;
    }
}
