package practice.dp.bag;

/**
 * @author Kelly
 * @create 2020-09-13 23:13
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class T494_TargetSum {
    /**
     * 定义状态：dp[i][j] 表示 nums 的前 i 个数字可以组成 j 的方法数
     * 状态转移：
     *      dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]]  当前数字不选或者选
     * base case:
     *      dp[i][0] = 1, dp[0][j] = 0
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        // 计算 nums 数组的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) return 0;
        int target = (sum + S) / 2;
        int n = nums.length;
        // 定义状态 dp[i][j] 表示 nums 的前 i 个数字可以组成 j 的方法数
        int[][] dp = new int[n + 1][target + 1];
        // base case dp[i][0] = 1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
