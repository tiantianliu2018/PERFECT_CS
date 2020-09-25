package practice.greedy;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-24 10:54
 */
public class T452_MinimumNumberOfArrowsToBurstBalloons {
    // 计算不重叠区间的个数
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            }
        }
        return res;
    }
}
