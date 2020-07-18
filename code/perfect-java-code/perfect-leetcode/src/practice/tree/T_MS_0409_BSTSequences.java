package practice.tree;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-18 11:32
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 */
public class T_MS_0409_BSTSequences {
    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            res.add(list);
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        list.add(root.val);
        dfs(root, res, list, queue);
        return res;
    }
    private void dfs(TreeNode node, List<List<Integer>> res, LinkedList<Integer> currList, LinkedList<TreeNode> queue) {
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
        if (queue.isEmpty()) {
            res.add(new LinkedList<>(currList));
            return;
        }
        //
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode pollNode = queue.poll();
            currList.add(pollNode.val);
            dfs(pollNode, res, currList, new LinkedList<TreeNode>(queue));
            currList.remove(currList.size() - 1);
            queue.offer(pollNode);
        }
    }
}
