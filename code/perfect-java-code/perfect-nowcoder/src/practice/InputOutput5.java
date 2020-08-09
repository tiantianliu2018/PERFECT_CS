package practice;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 10:25
 */
public class InputOutput5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().split(" ");
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Long.parseLong(arr[i]);
            }
            System.out.println(sum);
        }
    }
}
