package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-12 16:12
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 */

public class T426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历
     * @param node
     */
    public void dfs(Node node) {
        if (node == null) return;
        // 遍历左子树
        dfs(node.left);
        // 修改根节点的指针，pre 为上次的节点
        if (pre != null) {
            // 连接前一个节点
            pre.right = node;
            node.left = pre;
        } else {
            head = node;  // 第一个节点
        }
        pre = node;  // 将当前访问的节点记录下来
        dfs(node.right);
    }



}
