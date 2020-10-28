package practice.tree;

import java.util.HashMap;

/**
 * @author Kelly
 * @create 2020-10-24 16:24
 */
public class T106_ConstructBinaryTreeFromInorderAndPostorderTTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int postS, int postE, HashMap<Integer, Integer> map) {
        if (inS > inE || postS > postE) return null;
        int rootVal = postorder[postE];
        TreeNode root = new TreeNode(rootVal);
        // 根节点在中序遍历序列中的位置
        int index = map.get(rootVal);
        int rightCount = inE - index;  // 右子树的元素个数
        root.left = build(inorder, inS,index - 1,postorder,postS, postE - rightCount - 1, map);
        root.right = build(inorder,index + 1,inE, postorder,postE - rightCount,postE - 1,map);
        return root;
    }
}
