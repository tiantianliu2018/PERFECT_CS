package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Kelly
 * @create 2020-08-10 09:48
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 */
public class T03_RepeatNumber {
    // 借助 Hashset 判重
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                res = num;
                break;
            }
            set.add(num);
        }
        return res;
    }

    // 先排序，再查找相同的元素
    public int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }
}
