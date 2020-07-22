package bytedance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-19 16:58
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class T113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, int sum, ArrayList<Integer> list) {
        if (node == null) return;
        // 将当前节点的值加入 list
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (node.left != null) dfs(res, node.left, sum - node.val, list);
        if (node.right != null) dfs(res, node.right, sum - node.val, list);
        // 递归以后要重置
        list.remove(list.size() - 1);
    }
}
