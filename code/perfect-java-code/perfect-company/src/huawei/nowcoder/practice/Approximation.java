package huawei.nowcoder.practice;

import java.util.Scanner;

public class Approximation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float num = in.nextFloat();
        if (num - (int) num >= 0.5) {
            System.out.println((int) num + 1);
        } else {
            System.out.println((int) num);
        }
    }
}
