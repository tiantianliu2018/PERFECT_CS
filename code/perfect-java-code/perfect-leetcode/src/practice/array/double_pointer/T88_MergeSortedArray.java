package practice.array.double_pointer;

/**
 * @author Kelly
 * @create 2020-09-12 17:09
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class T88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i];
                i--;
            } else {
                nums1[end--] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[end--] = nums2[j--];
        }
    }
}
