package practice;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 10:13
 */
public class InputOutput2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
