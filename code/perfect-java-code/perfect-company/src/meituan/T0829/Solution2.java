package meituan.T0829;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-29 16:11
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = in.nextLine().split(" ");
            for (int j = 0; j < strs.length; j++) {
                matrix[i][j] = Integer.parseInt(strs[j]);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = matrix[i][j] - 1;
                if (res[pos] == 0) {
                    res[pos] = i + 1;
                    break;
                } else {
                    continue;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
