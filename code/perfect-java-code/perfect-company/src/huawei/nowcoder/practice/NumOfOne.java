package huawei.nowcoder.practice;

import java.util.Scanner;

public class NumOfOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int res = 0;
        while (num != 0) {
            res++;
            // 消除最右侧的 1
            num &= (num - 1);
        }
        System.out.println(res);
    }
}
