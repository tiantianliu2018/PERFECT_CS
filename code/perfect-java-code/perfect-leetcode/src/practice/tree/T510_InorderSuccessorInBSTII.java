package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-12 15:41
 * 给定一棵二叉搜索树和其中的一个节点 node ，找到该节点在树中的中序后继。
 * 如果节点没有中序后继，请返回 null 。
 * 一个结点 node 的中序后继是键值比 node.val 大所有的结点中键值最小的那个。
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
public class T510_InorderSuccessorInBSTII {
    /**
     * 如果当前节点有右子树，返回右子树中最左端的那个节点
     * 如果当前节点没有右子树：
     *      如果是父亲节点的左子树，返回父亲节点
     *
     */
    public Node inorderSuccessor(Node node) {
        // 当前节点有右子树
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 当前节点没有右子树，往上找，直到走到某个节点的左孩子
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;

    }
}
