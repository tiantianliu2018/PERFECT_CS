package practice.tree.BST;

import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-09-09 21:21
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class T235_LowestCommonAncestorOfABinarySearchTree {
    /**
     * 利用 BST 的性质, 左子树 < 根 < 右子树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
