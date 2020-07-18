package practice.sort;

/**
 * @author Kelly
 * @create 2020-07-16 22:03
 *
 * 快速排序
 */
public class QuickSort {
    public int[] quickSort(int[] nums, int left, int right){
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
        return nums;
    }
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotIndex = right;
        while (left < right) {
            while (left < right && nums[left] <= pivot) left++;
            while (left < right && nums[right] >= pivot) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        // 最后把 pivot 填上
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = new int[]{1,4,9,8,5,6,2,1};
        sort.quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
