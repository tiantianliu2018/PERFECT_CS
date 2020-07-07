package practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-07 09:30
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class T113_PathSumII {
    /**
     * 深度优先搜索 -- 回溯法
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    /**
     * @param res
     * @param node  当前节点
     * @param sum   剩下的和
     * @param list 记录走过的路径
     */
    private void dfs(List<List<Integer>> res, TreeNode node, int sum, ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        // 叶子节点，找到了一个答案
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(list));  // 深拷贝
            list.remove(list.size() - 1);
            return;
        }
        // 非叶子节点
        if (node.left != null) dfs(res, node.left, sum - node.val, list);
        if (node.right != null) dfs(res, node.right, sum - node.val, list);
        list.remove(list.size() - 1);
    }
}
