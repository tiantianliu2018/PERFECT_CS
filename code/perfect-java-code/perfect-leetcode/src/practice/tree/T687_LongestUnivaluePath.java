package practice.tree;

/**
 * @author Kelly
 * @create 2020-09-09 15:34
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 */
public class T687_LongestUnivaluePath {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * 搜索以某个节点为起点的最长路径，要么是该节点的左子树，要么是右子树
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);  // 左子树的同值最长路径
        int right = dfs(node.right); // 右子树的同值最长路径
        int leftPath = 0;
        int rightPath = 0;
        if (node.left != null && node.left.val == node.val) {
            leftPath = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1;
        }
        res = Math.max(res, leftPath + rightPath);  // 更新最大值
        return Math.max(leftPath, rightPath); // 返回上层，只能返回左边或者右边的最大值
    }

}
