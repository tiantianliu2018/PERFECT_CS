package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-12 20:47
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 */
public class T124_BinaryTreeMaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 更新全局最大路径
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        // 返回上层，只能返回左右子树中最大的那个
        return Math.max(left, right) + root.val;
    }
}
