package practice.tree;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-04 11:46
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。
 */
public class T617_MergeTwoBinaryTrees {
    // 递归方法
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }

    /**
     * 迭代方法，借助栈模拟递归，全部归并到 t1 上
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            // 加到第一棵树上
            nodes[0].val += nodes[1].val;
            // 处理左子树
            if (nodes[0].left != null && nodes[1].left != null) {
                stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
            } else if (nodes[0].left == null){
                // 若第一个的左子树为空，设为 t2 的左子树
                nodes[0].left = nodes[1].left;
            }
            // 处理右子树
            if (nodes[0].right != null && nodes[1].right != null) {
                stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            } else if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            }
        }
        return t1;
    }
}
