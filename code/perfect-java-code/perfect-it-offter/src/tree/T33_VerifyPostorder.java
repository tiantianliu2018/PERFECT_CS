package tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class T33_VerifyPostorder {
    /**
     * 二叉搜索树：左子树 < 根 < 右子树
     * 因此二叉搜索树的中序遍历是升序序列
     * 二叉搜索树后序遍历：左子树 - 右子树 - 根
     * 先找到最后一个根节点，然后遍历数组，找到第一个大于根的节点，然后再判断后面的是不是都大于根
     * 递归的判断左边和右边
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int rootVal = postorder[right];
        int i = left;
        while (i < right && postorder[i] < rootVal) {
            i++;
        }
        // left 指向第一个大于 根节点的节点
        int m = i;
        while (i < right) {
            if (postorder[i] < rootVal) return false;
            i++;
        }
        return verify(postorder, left, m - 1) && verify(postorder, m, right - 1);
    }
}
