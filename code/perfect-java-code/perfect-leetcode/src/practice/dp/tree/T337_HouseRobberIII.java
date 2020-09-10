package practice.dp.tree;

import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-09-09 16:05
 *
 * 树形 dp，dp 在树上更新
 */
public class T337_HouseRobberIII {
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * DFS 树，返回抢或者不抢当前节点的利益
     */
    private int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;
        // 抢左子树的结果
        int[] left = dfs(node.left);
        // 抢右子树的结果
        int[] right = dfs(node.right);
        // 当前节点不抢,左右孩子可抢可不抢的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点抢，那么左右孩子不能抢
        res[1] = node.val + left[0] + right[0];
        return res;
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 当前节点抢
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 当前节点不抢
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}
