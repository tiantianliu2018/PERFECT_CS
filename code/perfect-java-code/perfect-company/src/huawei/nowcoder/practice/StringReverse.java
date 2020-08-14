package huawei.nowcoder.practice;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            res.append(c);
        }
        System.out.println(res.toString());
    }
}
