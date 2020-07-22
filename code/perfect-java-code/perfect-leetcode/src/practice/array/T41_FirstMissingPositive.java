package practice.array;

/**
 * @author Kelly
 * @create 2020-07-19 15:10
 *
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
 */
public class T41_FirstMissingPositive {
    /**
     * 遍历数组中的每一个数，将它放在下标为【该数-1】的位置，最后判断
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 该数字在 [1,n] 之间，下标位置应该放在【0， n-1】的位置上
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
