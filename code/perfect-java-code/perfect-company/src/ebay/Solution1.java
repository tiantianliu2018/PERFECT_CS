package ebay;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-24 19:01
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = getMethods(n);
        System.out.println(res);
    }

    private static int getMethods(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; Math.pow(2, j) <= i; j++) {
                dp[i] += dp[i - (int) Math.pow(2, j)];
            }
        }
        return dp[n];
    }
}
