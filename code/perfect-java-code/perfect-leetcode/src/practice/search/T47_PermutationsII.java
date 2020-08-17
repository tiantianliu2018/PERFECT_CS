package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-15 09:31
 *
 * 给定一个【可包含重复数字】的序列，返回所有不重复的全排列。
 */
public class T47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, ArrayList<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 进行剪枝去重
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            backTracking(res, nums, curr, visited);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
