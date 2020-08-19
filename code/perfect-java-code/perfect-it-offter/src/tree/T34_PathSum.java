package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */

public class T34_PathSum {
    /**
     * 递归方法
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getPath(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    private void getPath(List<List<Integer>> res, TreeNode node, int sum, ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(list));
        }
        getPath(res, node.left, sum - node.val, list);
        getPath(res, node.right, sum - node.val, list);
        list.remove(list.size() - 1);
    }
}
