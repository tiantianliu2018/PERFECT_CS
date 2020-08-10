package string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class T05_ReplaceSpace {
    /**
     * 遍历一遍字符串，找到空格的个数，构建字符数组，从尾到头填充
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        int spaceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') spaceCount++;
        }
        char[] charArr = new char[s.length() + spaceCount * 2];
        int idx = charArr.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                charArr[idx--] = '0';
                charArr[idx--] = '2';
                charArr[idx--] = '%';
            } else charArr[idx--] = s.charAt(i);
        }
        return new String(charArr);
    }
}
