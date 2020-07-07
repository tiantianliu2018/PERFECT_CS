package vip;

/**
 * @author Kelly
 * @create 2020-07-02 19:45
 *
 * 给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。
 * 注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。
 * 请你计算并返回从数组中删除所有数字所需的最少操作次数。
 *
 * 微软 17
 *
 * 动态规划   区间 dp
 */
public class T1246_PalindromeRemoval {
    /**
     * 定义状态：dp[i][j] 表示从 i 到 j 删除所有数字所需的最少操作次数
     * base case :
     *      dp[i][i] = 1, 区间只有一个数字，一定是删除 1 次
     *      dp[
     * 状态转移：dp[i][j] = j-i+1 arr[i:j] 是回文串，
     *
     */
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            // 是回文可以一起删
            dp[i][i + 1] = (arr[i] == arr[i+1]) ? 1 : 2;
        }

        for (int j = 2; j < n; j++) {
            for (int i = j-2; i >= 0; i--) {
                int min = n;
                // 回文
                if (arr[i] == arr[j]) {
                    min = dp[i+1][j-1];
                }
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n - 1];
    }
}
