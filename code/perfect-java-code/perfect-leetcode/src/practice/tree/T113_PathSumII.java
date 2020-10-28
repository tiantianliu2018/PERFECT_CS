package practice.tree;

import practice.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-07 09:30
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class T113_PathSumII {
    /**
     * 深度优先搜索 -- 回溯法
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    /**
     * @param res
     * @param node  当前节点
     * @param sum   剩下的和
     * @param list 记录走过的路径
     */
    private void dfs(List<List<Integer>> res, TreeNode node, int sum, ArrayList<Integer> list) {
        if (node == null) return;
        // 将当前节点的值加入 list
        list.add(node.val);
        // 叶子节点，找到了一个答案
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(list));  // 深拷贝
            list.remove(list.size() - 1);
            return;
        }
        // 非叶子节点
        if (node.left != null) dfs(res, node.left, sum - node.val, list);
        if (node.right != null) dfs(res, node.right, sum - node.val, list);
        // 将加入的值移除
        list.remove(list.size() - 1);
    }

    // 2020 年 10 月 25 日再做一遍
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        search(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    /**
     * 回溯查找是否存在一个路径满足路径和
     */
    private void search(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer> curr) {
        curr.add(root.val);
        // 走到了叶子节点
        if (root.left == null && root.right == null && root.val == sum) {
            // 找到了一个解
            res.add(new ArrayList<>(curr));
            // 当前记录路径删除最后一个节点
            curr.remove(curr.size() - 1);
            return;
        }
        // 搜索左子树
        if (root.left != null) search(res, root.left, sum - root.val, curr);
        // 搜索右子树
        if (root.right != null) search(res, root.right, sum - root.val, curr);
        // 撤销选择
        curr.remove(curr.size() - 1);
    }
}
