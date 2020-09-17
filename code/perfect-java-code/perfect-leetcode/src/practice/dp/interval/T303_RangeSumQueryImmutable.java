package practice.dp.interval;

/**
 * @author Kelly
 * @create 2020-09-13 20:05
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
public class T303_RangeSumQueryImmutable {
    /**
     * 前缀和
     */
    int[] sumArr;
    public void NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        sumArr = new int[n];
        sumArr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sumArr[j];
        return sumArr[j] - sumArr[i - 1];
    }

}
