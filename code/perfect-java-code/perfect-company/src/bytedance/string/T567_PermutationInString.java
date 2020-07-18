package bytedance.string;

/**
 * @author Kelly
 * @create 2020-07-15 13:54
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 从第二个字符串中截取子串，看是否和 s1 有相同的字母和个数
 */
public class T567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // 将 s1 存到一个字符数组中
        int[] charArr = new int[26];
        for (char c : s1.toCharArray()) {
            charArr[c - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            String str = s2.substring(i, i + s1.length());
            System.out.println(str);
            int[] charArr2 = new int[26];
            for (char c : str.toCharArray()) {
                charArr2[c - 'a']++;
            }
            if (match(charArr, charArr2)) return true;
        }
        return false;
    }

    private boolean match(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
