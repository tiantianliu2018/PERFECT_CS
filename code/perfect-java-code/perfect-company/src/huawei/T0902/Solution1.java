package huawei.T0902;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-02 19:15
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] nums = new int[N];
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            String[] s = in.nextLine().split(" ");
            nums[i] = Integer.parseInt(s[0]);
            colors[i] = Integer.parseInt(s[1]);
        }

    }
}
