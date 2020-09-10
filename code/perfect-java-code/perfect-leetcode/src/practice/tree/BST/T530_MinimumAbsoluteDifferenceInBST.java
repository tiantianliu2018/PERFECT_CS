package practice.tree.BST;

import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-09-09 23:47
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 根据二叉树的性质，中序遍历是升序序列，那么任意两节点差的绝对值的最小值也只出现在相邻的两个值当中
 * 可以在中序遍历的同时，记录上一个节点的值，更新绝对值差的最小值
 */
public class T530_MinimumAbsoluteDifferenceInBST {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        // 更新差绝对值的最小值
        if (preNode != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - preNode.val));
        }
        preNode = root;
        inOrder(root.right);
    }

}
