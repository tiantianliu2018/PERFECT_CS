package dailychallenge.tree;

/**
 * @author Kelly
 * @create 2020-09-19 10:46
 */
public class T404_SumOfLeftLeaves {
    /**
     * 递归实现
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 说明 root.left 是左叶子节点
            sum += root.left.val;
        }
        // 递归访问左子树和右子树
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
