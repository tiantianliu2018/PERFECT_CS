package bytedance.dp;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-07-15 12:49
 */
public class T887_SuperEggDrop {
    /**
     * dp[x-1][j-1]  x 增大而增大
     * dp[i-x][j]  x 增大而减小
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        // base case   初始化，i 层楼最多 i 次，包含了 dp[i][1] = i
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
            dp[i][0] = 0;
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1, right = i;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    int broken = dp[mid-1][j-1];
                    int nonBroken = dp[i-mid][j];
                    if (broken > nonBroken) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1], dp[i-left][j]) + 1;
            }
        }
        return dp[N][K];
    }

    /**
     * dp[k][m] k 个鸡蛋，最多扔 m 次，可以确定的楼层数
     * dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;  总的楼层数 = 楼上的楼层数 + 楼下的楼层数 + 1（当前这层楼）
     *      dp[k][m-1] 鸡蛋没碎，m-1 次扔鸡蛋推测 dp[k][m-1]
     *      dp[k-1][m-1]  鸡蛋碎了，m-1 次扔鸡蛋推测 dp[k-1][m-1]
     */
    public static int superEggDrop2(int K, int N) {
        int [][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1;
            }
        }
        return m;
    }


    /**
     * 动态规划   复杂度太高，超时
     * 定义状态  dp[i][j] 表示 i 层楼 j 个鸡蛋的最小移动次数
     * 状态转移：dp[i][j] = min(dp[x-1][j-1], dp[i-x][j])     1 <= x <= i
     *      dp[x-1][j-1] 表示在第 x 层扔鸡蛋的时候碎了
     *      dp[i-x][j]  表示在第 x 层扔鸡蛋的时候没碎
     * base case:
     *      dp[0][j] = 0  0 层楼 j 个鸡蛋，都为 0
     *      dp[i][0] = 0  i 层楼 0 个鸡蛋，都为 0
     *      dp[1][j] = 1  1 层楼，j 个鸡蛋，扔 1 次就可以确定
     *      dp[i][1] = i  i 层楼，1 个鸡蛋，要扔 i 次，一层一层扔
     * 时间复杂度 O(n^3)
     */
    public static int superEggDrop1(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        // base case  初始化 i 层楼，扔 i 次
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        // 只有一个鸡蛋
        for (int i = 0; i <= N; i++) {
            dp[i][1] = i;
        }
        // 只有一层楼
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= N; i++) {      // 那些楼层
            for (int j = 2; j <= K; j++) {  // 鸡蛋的个数
                // 滚动更新最好的方法
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(Math.max(dp[k-1][j-1], dp[i-k][j]) + 1, dp[i][j]);
                }
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        int res = superEggDrop(2, 6);
        System.out.println(res);
    }

}
