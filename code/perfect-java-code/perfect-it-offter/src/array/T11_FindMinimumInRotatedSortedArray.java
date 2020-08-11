package array;

/**
 * @author Kelly
 * @create 2020-08-11 09:41
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 1. 遍历数组，如果某个数的前一个大于它，后一个也大于它，就找到了，时间复杂度 O(n)
 * 2. 由于数组是排序的，现在进行了旋转，部分有序，因此可以考虑用二分法
 */
public class T11_FindMinimumInRotatedSortedArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                // 旋转点一定在【mid+1, right】
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 旋转点在【left, mis】
                right = mid;
            } else {  // 相等，无法判断范围
                right -= 1;
            }
        }
        return numbers[left];
    }
}
