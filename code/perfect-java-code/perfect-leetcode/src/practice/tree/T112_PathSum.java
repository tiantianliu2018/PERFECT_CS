package practice.tree;

import javafx.util.Pair;
import sun.plugin.javascript.navig.Link;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-07-19 16:28
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class T112_PathSum {
    /**
     * DFS 递归
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 迭代, 通过栈
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int target  = pair.getValue();
            if (node.left == null && node.right == null && target == node.val) return true;
            if (node.left != null) stack.push(new Pair<>(node.left, target - node.val));
            if (node.right != null) stack.push(new Pair<>(node.right, target - node.val));
        }
        return false;
    }
}
