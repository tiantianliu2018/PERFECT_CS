package practice.tree.BST;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-09 23:42
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class T653_TwoSumIV_InputBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        // 中序遍历得到有序序列，然后双指针查找
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }

}
