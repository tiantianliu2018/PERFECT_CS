package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 12:12
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class T34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);
        return res;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1; // mid 一定不是解
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 下次搜索【left, mid - 1】
                right = mid - 1; // mid 一定不是解
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }
}
