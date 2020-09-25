package practice.array.sort;

import java.util.PriorityQueue;

/**
 * @author Kelly
 * @create 2020-09-23 14:11
 *
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class T215_KthLargestElementInAnArray {
    /**
     * 维持一个有 k 个元素的小顶堆，返回堆顶元素
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num > heap.peek()) {
                    heap.offer(num);
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }

    /**
     * 快速选择
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        int left = 0, right = nums.length - 1;
        while (true) {
            int idx = partition(nums, left, right);
            if (idx == k-1) return nums[idx];
            else if (idx < k-1) left = idx + 1;
            else right = idx - 1;
        }
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotIndex = right;
        while (left < right) {
            // 大于 pivot 放到左边
            while (left < right && nums[left] >= pivot) left++;
            while (right > left && nums[right] <= pivot) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }
}
