package practice.dp.extremum;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-20 10:06
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class T300_LongestIncreasingSubsequence {
    /**
     * 动态规划 + 二分查找的优化
     * 重新定义状态： tails[i] 表示长度为 i+1 的子序列末尾元素的值
     * 状态转移：保持 tails 为递增数组，并更新 tails
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int end = 0;  // tails 数组末尾的索引
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[end]) {
                tails[++end] = nums[i];
            } else {
                // 更新 tails 数组
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < nums[i]){
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = nums[i];
            }
        }
        return end + 1;
    }
    /**
     * 定义状态：
     *      dp[i] 表示以第 i 个字符结尾的数组中，最长上升子序列的长度
     * 状态转移：
     *      dp[i] = max(dp[j] + 1, dp[i]), nums[j] < nums[i] && j < i
     * base case: dp[i] = 1, 自身
     */
    public int lengthOfLIS1(int[] nums) {
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
