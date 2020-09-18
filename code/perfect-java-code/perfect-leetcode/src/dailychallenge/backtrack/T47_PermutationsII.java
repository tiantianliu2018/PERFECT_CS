package dailychallenge.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-18 09:11
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class T47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTracking(nums, res, new LinkedList<Integer>(), visited);
        return res;
    }

    private void backTracking(int[] nums, List<List<Integer>> res, LinkedList<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
            return;
        }
        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            if (visited[i]) continue;
            // 做选择
            curr.add(nums[i]);
            visited[i] = true;
            // 回溯
            backTracking(nums, res, curr, visited);
            // 撤销选择
            curr.removeLast();
            visited[i] = false;
        }
    }
}
