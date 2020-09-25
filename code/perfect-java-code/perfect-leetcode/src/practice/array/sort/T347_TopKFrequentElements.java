package practice.array.sort;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-09-24 08:57
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class T347_TopKFrequentElements {
    /**
     * 统计元素的频率，放入小顶堆，返回堆中的元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        // 统计元素的频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 根据元素的频率大小建立小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (map.get(num) > map.get(heap.peek())) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int num : heap) {
           res[i++] = num;
        }
        return res;
    }

    /**
     * 基于桶排序的思想，建立多个桶，每个桶的下标表示元素出现的频率，然后从大到小遍历桶中的元素
     */
    public int[] topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 桶，桶的下标作为频率
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : countMap.keySet()) {
            int frequency = countMap.get(num);
            if (buckets[frequency]  == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        // 统计元素的个数
        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 ; i--) {
            if (buckets[i] == null) continue;
            while (idx < k && !buckets[i].isEmpty()) {
                res[idx++] = buckets[i].remove(0);
            }
        }
        return res;
    }
}
