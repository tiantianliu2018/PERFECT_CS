package tencent.T0906;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-06 20:56
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(in.nextLine());
            int[] arr = new int[n];
            String[] s = in.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int left = 0, right = arr.length - 1;
            if (arr[left] < arr[right]) {

            }
        }
    }

    private static int getMaxUp(int[][] arr, int middleIdx) {
        int[] dp = new int[arr.length - middleIdx + 1];
        // 每个数字都可以构成一个长度为 1 的子序列
        Arrays.fill(dp, 1);
        int res = 1;  // 最终结果
        for (int i = middleIdx + 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);  // 在遍历的同时判断
        }
        return res;
    }

    private static int getMaxDown(int[][] arr, int middleIdx) {
        int[] dp = new int[middleIdx + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < middleIdx; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0] > arr[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);  // 在遍历的同时判断
        }
        return res;
    }
}
