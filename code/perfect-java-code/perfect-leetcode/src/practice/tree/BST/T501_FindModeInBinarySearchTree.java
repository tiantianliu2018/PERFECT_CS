package practice.tree.BST;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-09 23:55
 */
public class T501_FindModeInBinarySearchTree {
    /**
     * 中序遍历（升序，相同的值只可能出现在相邻位置），遍历的过程中统计相同元素的个数，并更新
     */
    TreeNode preNode = null;
    int maxCount = 1;
    int currCount = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        if (preNode != null) {
            // 比较当前节点和 preNode 值是否相同，相同则计数+1
            if (root.val == preNode.val) {
                currCount++;
            } else {
                currCount = 1;
            }
        }
        // 更新众数
        if (currCount > maxCount) {
            maxCount = currCount;
            list.clear();
            list.add(root.val);
        } else if (currCount == maxCount) {
            list.add(root.val);
        }
        preNode = root;
        inOrder(root.right, list);
    }
}
