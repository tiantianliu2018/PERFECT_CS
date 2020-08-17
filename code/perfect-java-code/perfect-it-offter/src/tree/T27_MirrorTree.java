package tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class T27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
