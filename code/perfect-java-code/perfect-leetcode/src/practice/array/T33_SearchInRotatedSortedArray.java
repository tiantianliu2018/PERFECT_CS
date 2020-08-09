package practice.array;

/**
 * @author Kelly
 * @create 2020-07-25 20:37
 *
 * 二分法
 */
public class T33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[right]) {
                // 【mid, right】 有序
                if (nums[mid] < target && target <= nums[right]) {
                    // 说明 target 在 (mid， right]
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 【left，mid】左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    // target 在 [left, mid)
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
