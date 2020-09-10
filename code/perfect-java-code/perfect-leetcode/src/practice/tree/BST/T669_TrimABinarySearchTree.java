package practice.tree.BST;

import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-09-09 16:47
 */
public class T669_TrimABinarySearchTree {
    /**
     * 就是一个前序遍历，递归解决
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        // 根节点的值大于 L，小于 R
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}

