package practice;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 10:05
 */
public class InputOutput1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
