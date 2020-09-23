package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 09:15
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */
public class T540_SingleElementInASortedArray {
    // 数组有序，可以进行二分查找
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;  // 保证 mid 都是奇数
            if (nums[mid] == nums[mid + 1]) {
                // 出现了两次，则 mid 前面的都出现了两次,结果在 【mid+2, right】中
                left = mid + 2;
            } else {
                // 【left, mid】中出现了这个只有一个的数，打乱了顺序
                right = mid;
            }
        }
        return nums[left];
    }
}
