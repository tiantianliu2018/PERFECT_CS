package practice.array;

/**
 * @author Kelly
 * @create 2020-07-23 19:36
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class T53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
