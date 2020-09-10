package practice.tree;

import javafx.util.Pair;
import jdk.nashorn.internal.ir.CallNode;

import javax.swing.*;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-09 10:51
 */
public class T404_SumOfLeftLeaves {
    // 递归方法
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        // 当前节点的左子树不为空，左子树的左子树、右子树均为空，说明当前节点的左子树是左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    /**
     * 迭代方法
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        stack.add(new Pair<>(root, false));
        int sum = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            TreeNode node = pair.getKey();
            Boolean flag = pair.getValue();
            if (flag && node.left == null && node.right == null) {
                sum += node.val;
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, true));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, false));
            }
        }
        return sum;
    }

}
