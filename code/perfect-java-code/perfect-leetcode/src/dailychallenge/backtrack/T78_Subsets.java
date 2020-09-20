package dailychallenge.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-20 09:44
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class T78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            // 子集的元素数量
            backTracking(res, nums, 0, new LinkedList<Integer>(), i);
        }
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, int start, LinkedList<Integer> curr, int count) {
        if (curr.size() == count) {
            res.add(new LinkedList<>(curr));
            return;
        }
        // 选择列表
        for (int i = start; i < nums.length; i++) {
            // 做选择
            curr.add(nums[i]);
            backTracking(res, nums, i + 1, curr, count);
            // 撤销选择
            curr.removeLast();
        }
    }
}
