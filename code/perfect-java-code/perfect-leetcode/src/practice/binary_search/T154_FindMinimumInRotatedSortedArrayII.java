package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 10:20
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 */
public class T154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 旋转点在【mid+1， right】
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 该区间内递增，旋转点在 【left, mid】
                right = mid;
            } else {
                // 如果相等，没有办法判断，只能逐渐收缩边界
                right = right - 1;
            }
        }
        return nums[left];
    }
}
