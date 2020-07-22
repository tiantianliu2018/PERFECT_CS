package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-19 18:35
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class T236_LowestCommonAncestorOfABinaryTree {
    /**
     * 如果该节点分别位于根节点的左右子树，说明公共祖先是根节点
     * 递归地去看能不能在同一棵子树中找到，找不到就返回根
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        // 递归找左子树存不存在一个 p 和 q 的公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归找右子树存不存在一个 p 和 q 的公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
