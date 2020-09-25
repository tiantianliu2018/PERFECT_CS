package practice.greedy;

/**
 * @author Kelly
 * @create 2020-09-25 10:04
 */
public class T665_NonDecreasingArray {
    /**
     * 非递减数列，如果当前 nums[i] 小于 nums[i-1], 那么修改 nums[i-1] = nums[i]
     * 如果修改 nums[i] 会对后面的元素造成影响
     * 特殊情况下，若 nums[i] < nums[i-2], 那么应该修改 nums[i] 为 nums[i-1]
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 2) return true;
        int count = 0; // 修改次数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                // 需要修改一次元素
                if (i >= 2 && nums[i] < nums[i-2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i-1] = nums[i];
                }
                count++;
            }
        }
        return count <= 1;
    }
}
