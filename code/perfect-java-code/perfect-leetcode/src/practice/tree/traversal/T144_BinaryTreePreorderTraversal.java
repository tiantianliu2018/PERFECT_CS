package practice.tree.traversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-04 09:36
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class T144_BinaryTreePreorderTraversal {
    /**
     * 递归方法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrder(res, root);
        return res;
    }

    private void preOrder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        // 访问根
        res.add(node.val);
        // 访问左子树
        preOrder(res, node.left);
        // 访问右子树
        preOrder(res, node.right);
    }

    /**
     * 迭代方法，借助栈，模拟递归
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 栈是先进后出，先 push 的后访问
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
