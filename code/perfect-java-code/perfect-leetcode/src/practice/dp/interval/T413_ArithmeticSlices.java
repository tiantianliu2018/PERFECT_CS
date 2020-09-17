package practice.dp.interval;

/**
 * @author Kelly
 * @create 2020-09-13 20:17
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 */
public class T413_ArithmeticSlices {
    /**
     * 定义状态：dp[i] 表示以 A[i] 结尾的等差数组的个数
     * 状态转移：
     *      dp[i] = dp[i-1] + 1 if A[i] - A[i-1] = A[i-1] - A[i-2]
     *  由于求所有等差子数组的总个数，所以要将 dp 数组进行累加
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }
}
