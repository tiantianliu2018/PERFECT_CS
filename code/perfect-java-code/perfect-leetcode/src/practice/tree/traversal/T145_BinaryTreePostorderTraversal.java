package practice.tree.traversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-04 10:16
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class T145_BinaryTreePostorderTraversal {
    /**
     * 递归方法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postOrder(res, root);
        return res;
    }

    private void postOrder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        // 左子树 - 右子树 - 根
        postOrder(res, node.left);
        postOrder(res, node.right);
        res.add(node.val);
    }

    /**
     * 迭代方法
     * 前序遍历是：根 - 左 - 右
     * 后序遍历是：左 - 右 - 根，前序遍历的栈可以构造出【根 - 右 - 左】的序列，就是后序遍历的相反序列
     * 因此可以用前序遍历的方法，结果采用头插法
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

    /**
     * 迭代方法 2
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode last = root;  // 上次访问的节点
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            // 当前栈顶的左右孩子都未访问过，存在左孩子，直接左孩子入栈
            if (curr.left != null && last != curr.left && last != curr.right) {
                stack.push(curr.left);
            } else if (curr.right != null && curr.right != last) {
                // 不存在左子树，但是存在右子树，并且右子树未处理过
                stack.push(curr.right);
            } else {
                // 左右子树都是处理过的，自底向上返回
                res.add(stack.pop().val);
                last = curr;
            }
        }
        return res;
    }
}
