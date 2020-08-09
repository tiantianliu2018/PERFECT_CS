package practice.dp;

/**
 * @author Kelly
 * @create 2020-08-08 10:02
 */
public class T152_MaximumProductSubarray {
    // dp[i][2] : 表示以 nums[i] 结尾的最大值和最小值
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
            }
        }
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
