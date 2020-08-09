package pdd;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 18:58
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            int[] arr = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
        }
    }
}
