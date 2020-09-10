package practice.tree.BST;

import practice.tree.TreeNode;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-09 20:11
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 */
public class T538_ConvertBSTToGreaterTree {
    /**
     * 递归方法，中序遍历逆序
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        // 先将右子树进行转换
        convertBST(root.right);
        // 当前节点的值累加 sum
        sum += root.val;
        root.val = sum;
        // 转换左子树
        convertBST(root.left);
        return root;
    }

    /**
     * 使用栈的迭代方法，模拟中序遍历逆序过程
     */
    public TreeNode convertBST1(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;
            if (node.left != null) curr = node.left;
        }
        return root;
    }
}
