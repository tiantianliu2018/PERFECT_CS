package practice.tree.traversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-09-04 11:02
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class T102_BinaryTreeLevelOrderTraversal {
    // 层次遍历，借助队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size(); // 每一层元素的个数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}
