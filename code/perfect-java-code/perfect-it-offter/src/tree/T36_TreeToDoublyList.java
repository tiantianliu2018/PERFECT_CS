package tree;

public class T36_TreeToDoublyList {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inOrder(Node curr) {
        if (curr == null) return;
        // 递归遍历左子树
        inOrder(curr.left);
        // 处理根节点
        if (pre != null) {
            pre.right = curr;
        } else {
            // pre 为 null, curr 是双向链表的头结点
            head = curr;
        }
        curr.left = pre;
        // 更新 pre 为 null
        pre = curr;
        // 递归遍历右子树
        inOrder(curr.right);
    }
}
