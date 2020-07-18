package practice.tree;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-07-12 11:33
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class T199_BinaryTreeRightSideView {
    /**
     * 迭代方法 BFS
     * 其实返回的就是层序遍历最右侧的节点，
     * 因此可以直接通过层序遍历来解决,当遍历到每一层的最后一个节点，加入结果
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();  // 队列
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }

    // 递归方法
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public void dfs(TreeNode node, int level, List<Integer> res) {
        // 访问当前节点
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        // 递归地访问右子树和左子树
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }
}
