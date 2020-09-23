package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-22 10:52
 *
 * 基础的二分查找
 */
public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7};
        int idx1 = binarySearch(nums, 5);
        int idx2 = binarySearch(nums, 4);
        System.out.println(idx1);
        System.out.println(idx2);
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
