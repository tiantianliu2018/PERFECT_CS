package huawei.nowcoder.practice;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class NumberInversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.append(num % 10);
            num /= 10;
        }
        System.out.println(res.toString());
    }
}
