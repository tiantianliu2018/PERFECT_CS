package practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-10 09:58
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class T40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backTracking(candidates, target, res, new LinkedList<Integer>(), 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> curr, int idx) {
        if (target == 0) {
            res.add(new LinkedList<>(curr));
            return;
        }
        // 选择列表
        for (int i = idx; i < candidates.length; i++) {
            // 剪枝
            if (candidates[i] > target) break;
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            // 做选择
            curr.add(candidates[i]);
            backTracking(candidates, target - candidates[i], res, curr, i + 1);
            // 撤销选择
            curr.removeLast();
        }
    }

}
