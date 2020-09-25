package dailychallenge.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-09-25 08:43
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class T106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 ) return null;
        // 用一个 map 保存中序序列的元素和位置下标，加速查找
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历序列中查找根节点的位置
        int idx = map.get(rootVal);
        int rightCount = inEnd - idx;
        root.left = build(inorder, inStart, idx - 1, postorder, postStart , postEnd - rightCount - 1);
        root.right = build(inorder, idx + 1, inEnd, postorder, postEnd - rightCount, postEnd - 1);
        return root;
    }
}
