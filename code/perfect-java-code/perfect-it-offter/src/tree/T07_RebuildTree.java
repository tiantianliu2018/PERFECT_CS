package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class T07_RebuildTree {
    // 递归的构建树，前序遍历：根 - 左 - 右， 中序遍历：左 - 根 - 右
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 遍历中序数组，存为一个 map，加快查找速度
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,0, n - 1, inorder, 0, n - 1);
    }
    public TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) return null;
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);  // 中序序列的位置
        root.left = build(preorder, pStart + 1, pStart + (index - inStart), inorder, inStart, index - 1);
        root.right = build(preorder, pStart + (index - inStart + 1), pEnd, inorder, index + 1, inEnd);
        return root;
    }
}
