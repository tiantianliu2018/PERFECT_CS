package ebay;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-24 19:01
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
            s = in.nextLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < s.length; j++) {
                nums[i] = Integer.parseInt(s[j]);
            }
            Arrays.sort(nums);
            boolean res = getAnswer(nums, m, k, 0, n-1);
            if (res) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean getAnswer(int[] nums, int m, int k, int left, int right) {
        if (m == 0) return true;
        while (left < right) {
            if ((nums[left] + nums[right]) % k == 0) {
                left++;
                right--;
                m -= 2;
            }
        }
        return getAnswer(nums, m, k, left, right);
    }
}
