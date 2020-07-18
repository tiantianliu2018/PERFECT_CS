package practice.sort;

/**
 * @author Kelly
 * @create 2020-07-16 22:43
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 递归地对左半边元素排序
            mergeSort(arr, left, mid);
            // 递归地对右边的元素排序
            mergeSort(arr, mid + 1, right);
            // 将左右两个区间 merge 起来
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        // 创建一个临时数组
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[r++];
            }
        }
        // 左半边剩元素未归并
        while (l <= mid) {
            temp[i++] = arr[l++];
        }
        while (r <= right) {
            temp[i++] = arr[r++];
        }
        // 将临时数组的值拷贝回原数组
        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] nums = new int[]{1,4,9,8,5,6,2,1};
        sort.mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
