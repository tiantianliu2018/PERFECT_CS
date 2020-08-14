package huawei.nowcoder.practice;

import java.util.Scanner;

/**
 * 三个空汽水瓶可以换一瓶汽水
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 */
public class SodaBottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            if (n == 0) break;
            System.out.println(n / 2);
        }
    }
}
