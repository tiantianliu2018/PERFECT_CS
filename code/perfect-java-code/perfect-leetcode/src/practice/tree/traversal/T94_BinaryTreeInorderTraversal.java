package practice.tree.traversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-04 09:50
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class T94_BinaryTreeInorderTraversal {
    /**
     * 递归方法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inOrder(res, root);
        return res;
    }

    private void inOrder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        inOrder(res, node.left);
        res.add(node.val);
        inOrder(res, node.right);
    }

    /**
     * 迭代方法，借助栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) curr = node.right;
        }
        return res;
    }
}
