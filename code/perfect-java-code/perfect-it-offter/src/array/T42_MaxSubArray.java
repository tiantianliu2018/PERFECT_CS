package array;

/**
 * @author Kelly
 * @create 2020-08-21 22:17
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 */
public class T42_MaxSubArray {
    /**
     * 动态规划 dp[i] 表示以 nums[i] 结尾的连续子数组的和和最大值
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心算法
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
