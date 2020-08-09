package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-07-22 20:04
 */
public class T101_SymmetricTree {
    /**
     * 递归写法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    /**
     * 判断两棵子树是否镜像对称
     */
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    /**
     * 迭代解法 BFS
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
