package practice.dp.extremum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kelly
 * @create 2020-09-21 09:11
 *
 * 给出 n 个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。
 *
 */
public class T646_MaximumLengthOfPairChain {
    /**
     * 首先根据区间的起始端点进行排序
     * 然后动态规划，搜索最长数对链
     * 定义状态：
     *      dp[i] 表示前 i 个数对可以组成的数对链的长度
     * 状态转移：
     *      dp[i] = max(dp[i], dp[j]+1)  j < i, pairs[j][1] < pais[i][0]
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 也可以将数组按照尾元素进行排序，那么尽量选择更多的数组就可以了
     * 贪心算法
     */
    public int findLongestChain1(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int temp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > temp) {
                res++;
                temp = pairs[i][1];
            }
        }
        return res;
    }
}
