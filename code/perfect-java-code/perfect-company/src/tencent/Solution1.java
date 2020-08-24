package tencent;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-23 19:52
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String[] numStr = in.nextLine().split(" ");
        int[] arr = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            arr[i] = Integer.parseInt(numStr[i]);
        }
        arr[n-k] = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Integer.MAX_VALUE) continue;
            res.append(arr[i] + " ");
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}

//n, k = list(map(int, input().split()))
//arr = list(input().split())
//arr.pop(k-1)
//res = " ".join(arr)
//print(res)
