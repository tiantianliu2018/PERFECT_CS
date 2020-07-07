package bytedance.tree;

/**
 * @author Kelly
 * @create 2020-07-01 09:55
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 */
public class T236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p, q 分别在左右子树，公共祖先是 根节点
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
