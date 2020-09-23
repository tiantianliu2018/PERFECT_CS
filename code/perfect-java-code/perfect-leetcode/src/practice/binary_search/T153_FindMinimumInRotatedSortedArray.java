package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 09:34
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 请找出其中最小的元素。
 * 假设数组中没有重复元素
 */
public class T153_FindMinimumInRotatedSortedArray {
    /**
     * 数组旋转以后，还是会保持部分有序，并且旋转点左边的数都大于其右边的数
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
            System.out.print("nums[left]: " + nums[left] + "\t");
            System.out.print("nums[mid]: " + nums[mid] + "\t");
            System.out.println("nums[right]: " + nums[right]);
            System.out.println("===============");
            if (nums[mid] < nums[right]) {
                // 右半部分有序，旋转点在【left, mid】，mid 有可能是解
                right = mid;
            } else {
                // 旋转点一定在右边 【mid + 1, right】, mid 一定不是解
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
