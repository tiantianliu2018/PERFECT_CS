package practice.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-07-22 19:26
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class T105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        // 加速中序遍历查找
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            posMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder,0, inorder.length - 1, posMap);
    }
    public TreeNode build(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE, Map<Integer, Integer> posMap) {
        if (preS > preE || inS > inE) return null;
        int val = preorder[preS];
        TreeNode root = new TreeNode(val);
        // 找到根节点在中序遍历序列中的位置
        int index = posMap.get(val);
        // 递归地建树
        root.left = build(preorder, preS + 1, preS + index - inS,
                inorder, inS, index - 1, posMap);
        root.right = build(preorder, preS + index - inS + 1, preE,
                inorder, index + 1, inE, posMap);
        return root;
    }
}
