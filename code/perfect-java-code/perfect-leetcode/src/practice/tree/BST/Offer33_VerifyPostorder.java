package practice.tree.BST;

/**
 * @author Kelly
 * @create 2020-07-24 23:06
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 二叉搜索树，中序 左子树 < 根 < 右子树
 * 后序：左子树，右子树，根
 */
public class Offer33_VerifyPostorder {
    /**
     * 找到二叉搜索树的根节点，然后找到第一个大于根的节点，那么此后的节点应该都大于根
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verify(postorder, 0, postorder.length - 1);
    }
    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int rootVal = postorder[end];  // []
        int i = start;
        // 最终 i 指向第一个大于根节点的位置
        while (i < end && postorder[i] < rootVal) i++;
        // 看右子树是不是全部大于根节点
        for (int j = i; j < end; j++) {
            if (postorder[j] < rootVal) return false;
        }
        return verify(postorder, start, i - 1) && verify(postorder, i, end - 1);
    }
}
