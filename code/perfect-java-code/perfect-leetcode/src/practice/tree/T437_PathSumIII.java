package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-07 09:56
 *
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的
 */
public class T437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == sum) count++;
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
