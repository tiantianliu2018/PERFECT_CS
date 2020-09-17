package practice.dp.bag;

/**
 * @author Kelly
 * @create 2020-09-13 20:54
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class T416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        // 先计算一个和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;  // 可以看成是背包大小为 sum/2 的背包问题
        int n = nums.length;
        // dp[i][j] 表示前 i 个数的和为 j 时，是否符合条件
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 容量不足
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 可选择装入或者不装入
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

    // 状态压缩
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        // base case
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
