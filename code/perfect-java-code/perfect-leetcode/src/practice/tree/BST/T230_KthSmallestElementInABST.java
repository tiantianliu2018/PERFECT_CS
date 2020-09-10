package practice.tree.BST;

import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-09-09 16:50
 */
public class T230_KthSmallestElementInABST {
    /**
     * 二叉搜索树的中序遍历是升序序列，中序遍历，返回第 k 个节点
     */
    int val;
    int count;
    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) return -1;
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    /**
     * 分治法
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int left = nodeCount(root.left);
        // 左子树的节点数刚好为 k-1，答案是根节点
        if (left == k - 1) return root.val;
        // 左子树的节点数大于 k-1，答案在左子树当中
        if (left > k - 1) return kthSmallest(root.left, k);
        // 左子树的节点数小于 k-1，答案在右子树中
        else return kthSmallest(root.right, k - left - 1);
    }
    private int nodeCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + nodeCount(node.left) + nodeCount(node.right);
    }
}
