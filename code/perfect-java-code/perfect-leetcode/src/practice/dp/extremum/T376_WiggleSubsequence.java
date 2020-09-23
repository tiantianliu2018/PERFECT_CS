package practice.dp.extremum;

/**
 * @author Kelly
 * @create 2020-09-22 09:37
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class T376_WiggleSubsequence {
    /**
     * 由于动态规划中 up 和 down 只和前一个元素相关，因此可以只用一个变量表示，滚动更新
     * @param nums
     * @return
     */
    public int wiggleMaxLength1(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n < 2) return n;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    /**
     * 动态规划：
     *      up[i] 表示前 i 个数字形成的子序列中最后两个数字递增的子序列的长度
     *      down[i] 表示前 i 个数字形成的子序列中最后两个数字递减的子序列的长度
     * 状态转移：
     *      nums[i] > nums[i-1] up[i] = down[i-1] + 1
     *      nums[i] < nums[i-1] down[i] = up[i-1] + 1
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                // 递减序列
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1], down[n-1]);
    }


}
