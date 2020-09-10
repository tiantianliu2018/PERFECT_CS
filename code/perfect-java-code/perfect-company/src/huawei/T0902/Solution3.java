package huawei.T0902;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-02 19:05
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = Integer.parseInt(in.nextLine()); // 卡车空间
        int N = Integer.parseInt(in.nextLine());  // 箱子个数
        int[] weights = new int[N];
        int[] values = new int[N];
        String[] s = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(s[i]);
        }
        s = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(s[i]);
        }
//        int[] dp = new int[K + 1];
//        for (int i = 1; i <= N; i++) {
//            int w = weights[i - 1], v = values[i - 1];
//            for (int j = K; j >= 1; j--) {
//                if (j >= w) {
//                    dp[j] = Math.max(dp[j], dp[j - w] + v);
//                }
//            }
//        }
//        System.out.println(dp[K]);
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= K; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
