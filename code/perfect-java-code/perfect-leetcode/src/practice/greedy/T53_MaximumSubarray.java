package practice.greedy;

/**
 * @author Kelly
 * @create 2020-09-25 10:17
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class T53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
