package tencent;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-23 19:53
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nS = in.nextLine();
        int n = Integer.parseInt(nS);
        String[] s = in.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int res = dfs(arr, 0, arr.length - 1);
        System.out.println(res);

    }
    private static int dfs(int[] arr, int l, int r) {
        int currMin = arr[l];
        if (r + 1 > l) {
            for (int i = l; i <= r; i++) {
                currMin = Math.min(currMin, arr[i]);
            }
        }
        for (int i = l; i <= r; i++) {
            arr[i] -= currMin;
        }
        int begin = 1;
        int t = currMin;
        for (int i = l; i <= r; i++) {
            if (arr[i] != 0) {
                begin = i;
                break;
            }
        }
        for (int i = begin; i <= r; i++) {
            if (arr[i] == 0) {
                t += dfs(arr, begin, i - 1);
                begin = i + 1;
            }
        }
        if (begin <= r) {
            t += dfs(arr, begin, r);
        }
        return Math.min(r-l+1, t);
    }
}
