package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-15 09:17
 *
 * 给定一个 【没有重复】 数字的序列，返回其所有可能的全排列。
 */
public class T46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        backTracking(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, ArrayList<Integer> currPath, boolean[] visited) {
        if (currPath.size() == nums.length) {
            res.add(new ArrayList<>(currPath));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 做选择
            visited[i] = true;
            currPath.add(nums[i]);
            backTracking(res, nums, currPath, visited);
            // 撤销选择
            currPath.remove(currPath.size() - 1);
            visited[i] = false;
        }
    }
}
