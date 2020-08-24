package design;

import java.util.PriorityQueue;

/**
 * @author Kelly
 * @create 2020-08-21 21:50
 *
 * 数据流的中位数，分别建立两个堆，一个大顶堆，一个小顶堆，维护两个堆的数量基本一致
 */
public class T41_MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public T41_MedianFinder() {
        minHeap = new PriorityQueue<>();  // 默认小顶堆
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        // 奇数个的时候，大顶堆多一个元素
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

}
