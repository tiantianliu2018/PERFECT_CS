package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-13 15:43
 */
public class T213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        // 要么不偷第一间，要么不偷最后一间，两者中较大的
        return Math.max(rob(nums, 0, n-1),rob(nums, 1, n));
    }
    // 给定区间起始和结束位置，求可以偷窃的最大值
    public int rob(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = start; i < end; i++) {
            int curr = Math.max(first + nums[i], second);
            first = second;
            second = curr;
        }
        return second;
    }
}

