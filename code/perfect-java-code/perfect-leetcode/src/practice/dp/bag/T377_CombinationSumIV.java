package practice.dp.bag;

/**
 * @author Kelly
 * @create 2020-09-16 10:55
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */
public class T377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        // base case
        dp[0] = 1;
        // 因为要得到 dp 数组，外层循环【1-target】
        for (int i = 1; i <= target; i++) {
            // 内存循环就是不同的选择
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
