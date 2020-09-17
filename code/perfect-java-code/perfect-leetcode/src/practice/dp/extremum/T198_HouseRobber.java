package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-13 15:27
 */
public class T198_HouseRobber {
    /**
     * 一维动态规划
     * 状态定义：dp[i] 表示偷窃到第 i 个房间可以获得的最大偷窃金额
     * 状态转移：dp[i] = max(dp[i-1],dp[i-2] + nums[i])
     * base case: dp[0] = 0, dp[1] = nums[0] -- 偷窃到第一间房间
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // 表示偷窃到第 i 个房间可以获得的最大偷窃金额
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            // 不偷前一个房间偷当前房间 or 偷前一个房间不偷当前房间 的最大值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
    // 状态压缩，由于每次只用到前两个状态，因此可以只用两个变量保存前两个状态
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int first = 0, second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(first + nums[i], second);
            first = second;
            second = curr;
        }
        return second;
    }
}
