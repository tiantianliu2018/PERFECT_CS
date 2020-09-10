package string;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */

public class T20_IsNumber {
    /**
     *  数字的格式可以用 A[.[B]][e|EC] 或者 .B[e|EC] 表示，
     *  其中 A 和 C 都是整数（可以有正负号，也可以没有），而 B 是一个无符号整数
     */
    int idx = 0;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim(); // 去掉首尾的空格
        boolean A = scanInteger(s);
        boolean B = false;
        // 找小数部分
        if (idx < s.length() && s.charAt(idx) == '.') {
            idx++;  // 跳过当前小数点
            B = scanUnsignedInteger(s);
        }
        // 看 E/e
        if (idx < s.length() && (s.charAt(idx) == 'E' || s.charAt(idx) == 'e')) {
            idx++;
            boolean C = scanInteger(s);
            // C 不是整数，直接返回 false
            if (!C) return false;
        }
        // 返回是否遍历到末尾，并且有 A 或者是 B
        return idx == s.length() && (A || B);
    }

    private boolean scanInteger(String s) {
        // 找符号
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            idx++;
        }
        // 符号后面是否是无符号整数
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int start = idx;
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            idx++;
        }
        // idx 大于 start 说明找到了无符号整数
        return idx > start;
    }
}
