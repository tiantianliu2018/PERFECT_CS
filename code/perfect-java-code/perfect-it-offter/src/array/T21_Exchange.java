package array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class T21_Exchange {
    /**
     * 双指针两头遍历，前面遇到偶数暂停，后面遇到奇数暂停，交换元素位置
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) left++;
            while (right > left && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
