package dailychallenge.tree;

/**
 * @author Kelly
 * @create 2020-09-21 08:47
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class T538_ConvertBSTToGreaterTree {
    /**
     * 二叉搜索树左子树 < 根 < 右子树
     * 前序遍历序列：左子树 - 根 - 右子树，则前序遍历的反向是递减序列
     */
    int sum = 0;  // 全局 sum，保存历史和
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        // 先访问右子树
        convertBST(root.right);
        // 访问根节点
        sum += root.val;
        root.val = sum;
        // 访问左子树
        convertBST(root.left);
        return root;
    }

}
