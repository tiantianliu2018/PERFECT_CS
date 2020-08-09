package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 10:28
 */
public class StringsSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] strings = in.nextLine().split(" ");
        Arrays.sort(strings);
        for (int i = 0; i < strings.length - 1; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println(strings[strings.length - 1]);
    }
}
