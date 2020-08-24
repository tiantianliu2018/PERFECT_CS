package tencent;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-23 21:13
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String Q = in.nextLine();
        int q = Integer.parseInt(Q);
        for (int k = 0; k < q; k++) {
            String[] arr = in.nextLine().split(" ");
            int begin = Integer.parseInt(arr[0]) - 1;
            int end = Integer.parseInt(arr[1]);
            String sub = s.substring(begin, end);
            System.out.println(sub);
            int len = sub.length();
            int[] f = new int[len + 1];
            int[][] dp = new int[len][len];
            for (int i = 0; i <= len; i++) {
                f[i] = len - 1 - i;
            }
            for (int i = len - 1; i >= 0 ; i--) {
                dp[i][i] = 1;
                for (int j = i; j < len; j++) {
                    if (sub.charAt(i) == sub.charAt(j) && ((j - i < 2) || dp[i + 1][j-1] == 1)) {
                        dp[i][j] = 1;
                        f[i] = Math.min(f[i], f[j+1] + 1);
                    }
                }
            }
            System.out.println(f[0] + 1);
        }
    }
}
