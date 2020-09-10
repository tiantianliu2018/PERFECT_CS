package practice.string;

/**
 * @author Kelly
 * @create 2020-08-24 14:50
 *
 * 求两个字符串形式的非负整数的乘积
 */
public class T43_MultiplyStrings {
    /**
     * 优化解法
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];
        // 逐位相乘
        for (int i = n - 1; i >= 0 ; i--) {  // 乘数
            for (int j = m - 1; j >= 0 ; j--) { // 被乘数
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 对应索引位置
                int p1 = i + j;
                int p2 = i + j + 1;
                temp += res[p2]; // 上一次的进位
                res[p1] += temp / 10;
                res[p2] = temp % 10;
            }
        }
        // 结果中可能存在前缀 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }

    /**
     * 模拟，逐位相乘再相加
     */
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(), m = num2.length();
        String res = "0";
        for (int i = m - 1; i >= 0 ; i--) {
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = m - 1; j > i; j--) {
                temp.append(0);
            }
//            System.out.println(temp);
            int y = num2.charAt(i) - '0';
            int carry = 0;
            // 用第二个数的某一位 y × 被乘数的每一位
            for (int j = n - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                temp.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) {
                temp.append(carry % 10);
            }
            System.out.println(res);
            System.out.println(temp.reverse().toString());
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }
    // 将前面的得到的结果和当前结果逐位相加
    private static String addStrings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = (i < 0) ? 0 : s1.charAt(i) - '0';
            int y = (j < 0) ? 0 : s2.charAt(j) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = multiply1("123", "45");
        System.out.println(s);
    }
}
