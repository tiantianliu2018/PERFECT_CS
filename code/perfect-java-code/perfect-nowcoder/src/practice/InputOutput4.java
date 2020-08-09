package practice;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 10:19
 */
public class InputOutput4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 样例的个数
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
