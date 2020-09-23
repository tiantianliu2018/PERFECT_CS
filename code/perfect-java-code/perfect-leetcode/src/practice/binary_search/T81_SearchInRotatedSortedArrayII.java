package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 10:45
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2])。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class T81_SearchInRotatedSortedArrayII {
    /**
     * 和 T33 不同的是，数组中存在重复元素
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // nums[mid] == nums[right], 无法判断
                // 收缩右边界，去重
                while (left <= right && nums[mid] == nums[right]) right--;
                while (left <= right && nums[mid] == nums[left]) left++;
            }
        }
        return false;
    }

}
