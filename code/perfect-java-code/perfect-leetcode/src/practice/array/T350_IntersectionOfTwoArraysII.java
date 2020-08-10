package practice.array;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-09 09:35
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 1. HashMap 统计元素出现的次数
 * 2. 排序以后双指针
 */
public class T350_IntersectionOfTwoArraysII {
    // HashMap
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (int num : nums2) {
            if (map.get(num) > 0) {
                resList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
