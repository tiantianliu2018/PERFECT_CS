package practice.tree;

/**
 * @author Kelly
 * @create 2020-08-17 09:35
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class T110_BalancedBinaryTree {
    /**
     * 从上到下的递归，双重递归
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // 计算两棵子树的高度，然后判断高度差
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    /**
     * 自底向上的判断，先判断左右子树是否平衡，然后判断根节点，只要有一个不平衡，就不是平衡二叉树
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return recur(root) != -1;
    }
    // 返回树的高度的同时，判断当前子树是否是平衡树
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        // 非平衡，返回 -1
        if (left == -1 || right == -1) return -1;
        // 非平衡返回 -1
        if (Math.abs(left - right) > 1) return -1;
        // 平衡返回高度
        return Math.max(left, right) + 1;
    }
}
