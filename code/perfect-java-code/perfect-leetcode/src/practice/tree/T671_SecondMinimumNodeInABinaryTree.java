package practice.tree;

/**
 * @author Kelly
 * @create 2020-09-09 16:34
 */
public class T671_SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (root.val == left) left = findSecondMinimumValue(root.left);
        if (root.val == right) right = findSecondMinimumValue(root.right);
        // 左右子树都找了，返回二者中较小的一个
        if (left != -1 && right != -1) return Math.min(left, right);
        //  左子树找到了，右子树没找到，返回左子树结果
        if (left != -1) return left;
        // 左子树没找到，右子树找到了，返回右子树结果
        return right;
    }
}
