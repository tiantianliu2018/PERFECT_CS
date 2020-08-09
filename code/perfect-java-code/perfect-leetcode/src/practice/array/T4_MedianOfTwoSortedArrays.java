package practice.array;

/**
 * @author Kelly
 * @create 2020-07-25 17:39
 */
public class T4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length; // 较短
        int n = nums2.length;   // 较长
        // 在区间 【0,m】查找分割线的位置，使其满足交叉小于等于
        // nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0, right = m;
        // 分割线左边元素的个数， 奇数的话多一个,偶数一样多
        int leftTotal = (m + n + 1) / 2;
        while (left < right) {
            int i = left + (right - left) / 2;  // 第一个数组分割线左边的元素个数
            int j = leftTotal - i;  // 第二个数组分割线左边的元素的个数
            if (nums2[j-1] > nums1[i]) {
                // 交叉大于，第一个数组的左边分少了, 分割线向右移动
                left = i + 1;
            } else {
                right = i;
            }
        }
        int i = left;
        int j = leftTotal - i;
        // 查看分割线左右两侧四个元素的情况
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int num1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int num2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 != 0) return Math.max(nums1LeftMax, nums2LeftMax);
        else return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2.0;
    }
}
