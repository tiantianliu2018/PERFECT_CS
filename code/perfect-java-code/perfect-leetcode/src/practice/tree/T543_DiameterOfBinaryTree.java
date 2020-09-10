package practice.tree;

/**
 * @author Kelly
 * @create 2020-09-04 11:31
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 该题目基本和 124 是一样的
 */
public class T543_DiameterOfBinaryTree {
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getMaxDiameter(root);
        return diameter;
    }
    public int getMaxDiameter(TreeNode node) {
        if (node == null) return 0;
        int left = getMaxDiameter(node.left);
        int right = getMaxDiameter(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
