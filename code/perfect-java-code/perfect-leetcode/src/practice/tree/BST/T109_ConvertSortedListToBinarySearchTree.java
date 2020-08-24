package practice.tree.BST;

import practice.linkedlist.ListNode;
import practice.tree.TreeNode;

/**
 * @author Kelly
 * @create 2020-08-18 09:15
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 要想高度平衡，最好将链表的中间节点作为根节点，然后其左右两边分别作为左右子树
 */
public class T109_ConvertSortedListToBinarySearchTree {
    /**
     * 1. 链表中间节点作为根节点（快慢指针找中点）
     * 2. 递归的构建左右子树
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode pre = findMiddleNodePre(head);
        System.out.println(pre.val);
        ListNode middle = pre.next;
        pre.next = null;  // 断开前半部分
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }
    // 返回中间节点的前一个节点
    private ListNode findMiddleNodePre(ListNode head) {
        ListNode slow = head, fast = head.next, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    /**
     * 使用递归，模拟中序遍历的过程，因为 BST 的中序遍历就是升序序列
     */
    private ListNode node;
    public TreeNode sortedListToBST1(ListNode head) {
        int idx = 0;
        node = head;
        while (head != null) {
            head = head.next;
            idx++;
        }
        return buildBTS(0, idx - 1);
    }

    private TreeNode buildBTS(int left, int right) {
        if (left > right) return null;
        int m = (left + right) / 2;
        TreeNode leftTree = buildBTS(left, m - 1);
        TreeNode father = new TreeNode(node.val);
        node = node.next;
        father.left = leftTree;
        father.right = buildBTS(m + 1, right);
        return father;
    }
}
