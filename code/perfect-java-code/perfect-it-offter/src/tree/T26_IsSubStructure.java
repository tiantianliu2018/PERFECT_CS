package tree;

/**
 * 输入两棵二叉树 A和 B，判断 B是不是 A的子结构。(约定空树不是任意一个树的子结构)
 * B是 A的子结构， 即 A中有出现和 B相同的结构和节点值。
 */
public class T26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isRoot(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    // 判断 node1 能否作为 node2 的根节点
    public boolean isRoot(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null || node1.val != node2.val) return false;
        return isRoot(node1.left, node2.left) && isRoot(node1.right, node2.right);
    }
}
