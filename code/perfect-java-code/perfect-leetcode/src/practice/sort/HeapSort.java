package practice.sort;

/**
 * @author Kelly
 * @create 2020-07-16 23:26
 */
public class HeapSort {
    public void heapSort(int[] arr) {
        // 构建大顶堆
        buildHeap(arr);
        // 从最后一个节点开始，调整
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆尾和堆顶交换
            swap(arr, i, 0);
            // 重新调整堆
            adjustHeap(arr, 0,i);
        }
    }

    /**
     * 构建堆
     */
    public void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    // 调整堆
    private void adjustHeap(int[] arr, int index, int n) {
        int maxIndex = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex < n && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex < n && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }
        // 根不都大于左右子树
        if (maxIndex != index) {
            swap(arr, index, maxIndex);
            adjustHeap(arr, maxIndex, n);
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
