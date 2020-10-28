package practice.array.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kelly
 * @create 2020-10-27 10:17
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class T128_LongestConsecutiveSequence {
    // 用 HashMap 记录 【一个元素，以及以该元素作为端点时序列的长度】
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int maxLen = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int currLen = left + right + 1;
            // 更新最长序列的长度
            maxLen = Math.max(maxLen, currLen);
            // 更新 hashmap 中的边界值
            map.put(num, currLen);
            map.put(num - left, currLen);
            map.put(num + right, currLen);
        }
        return maxLen;
    }

    // Hashset 去重，线性查找
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Set<Long> set = new HashSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            set.add((long) nums[i]);
        }
        int maxLen = 1;
        // 遍历 set 中的每一个数字
        for (long num : set) {
            // 从一个新的起点开始计算
            if (!set.contains(num - 1)) {
                int currLen = 1;
                // 统计连续序列
                while (set.contains(++num)) currLen++;
                // 更新最长序列
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
