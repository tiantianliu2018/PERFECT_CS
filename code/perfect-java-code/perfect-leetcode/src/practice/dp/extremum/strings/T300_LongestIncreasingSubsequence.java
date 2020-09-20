package practice.dp.extremum.strings;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-20 10:06
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class T300_LongestIncreasingSubsequence {
    /**
     * 定义状态：
     *      dp[i] 表示以第 i 个字符结尾的数组中，最长上升子序列的长度
     * 状态转移：
     *      dp[i] = max(dp[j] + 1, 1), Sj < Si && j < i
     * base case: dp[i] = 1, 自身
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        // base case
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
