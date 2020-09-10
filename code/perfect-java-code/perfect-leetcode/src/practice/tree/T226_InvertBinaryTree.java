package practice.tree;

/**
 * @author Kelly
 * @create 2020-09-04 11:39
 *
 * 翻转一棵二叉树。
 */
public class T226_InvertBinaryTree {
    /**
     * 递归方法, 相当于后序遍历
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
