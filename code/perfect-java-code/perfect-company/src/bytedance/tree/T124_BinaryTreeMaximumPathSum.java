package bytedance.tree;

/**
 * @author Kelly
 * @create 2020-07-02 10:01
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 */
public class T124_BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
        return maxSum;
    }

    /**
     * 返回一个节点的路径和
     */
    public int getPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, getPathSum(node.left));
        int right = Math.max(0, getPathSum(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);  // 更新最大路径
        return Math.max(left, right) + node.val;  // 返回左子树或右子树中最大的一个
    }
}
