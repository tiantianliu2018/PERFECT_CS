package array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-08-21 21:33
 */
public class T40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k > arr.length || k <= 0) return new int[0];
        return findK(arr, 0, arr.length - 1, k - 1);
    }

    private int[] findK(int[] arr, int left, int right, int k) {
        int index = partition(arr, left, right);
        if (index == k) {
            return Arrays.copyOf(arr, index);
        } else if (index < k) {
            return findK(arr, index + 1, right, k);
        } else {
            return findK(arr, left, index - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotIndex = left;
        while (left < right) {
            while (right > left && arr[right] >= pivot) right--;
            while (left < right && arr[left] <= pivot) left++;
            // 交换位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        // 将 pivot 填到该位置上
        arr[pivotIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
