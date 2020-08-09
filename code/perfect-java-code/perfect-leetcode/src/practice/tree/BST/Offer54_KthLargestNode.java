package practice.tree.BST;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-25 20:25
 *
 * 二叉搜索树的中序遍历序列是有序的，因此可以进行中序遍历，返回倒数第 k 个节点
 * 左子树 - 根 - 右子树
 *
 * 进阶：右子树 - 根 - 左子树，递减，迭代遍历，只需要遍历 k 个节点
 */
public class Offer54_KthLargestNode {
    int visited = 0;
    int res = 0;
    public int kthLargest1(TreeNode root, int k) {
        if (root == null) return -1;
        inOrderReverse(root, k);
        return res;
    }
    private void inOrderReverse(TreeNode root, int k) {
        if (root == null) return;
        inOrderReverse(root.right, k);
        visited++;
        if (visited == k) {
            res = root.val;
            return;
        }
        inOrderReverse(root.left, k);
    }

    /**
     * 中序遍历，返回倒数第 k 个元素
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        if (list.size() < k) return -1;
        inOrder(list, root);
        return list.get(list.size() - k);
    }
    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }
}
