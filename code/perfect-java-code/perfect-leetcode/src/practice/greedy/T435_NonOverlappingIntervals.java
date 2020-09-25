package practice.greedy;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-24 10:47
 */
public class T435_NonOverlappingIntervals {
    /**
     * 区间总数 - 最大不重叠区间的个数 = 要移除区间的最小数量
     * 尽量选择区间末尾比较小的，这样后面才有可能跟更多的区间
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 1;  // 记录不重叠区间的个数
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
