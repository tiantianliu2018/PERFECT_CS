package linkedlist;

import java.util.List;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class T18_DeleteNode {
    /**
     * 遍历链表，找到相应值的节点，将其 next 节点删除，并将当前节点的值设为其 next 节点的值
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head, curr = head.next;
        while (curr != null) {
            // 找到了目标节点，进行删除
            if (curr.val == val) {
                pre.next = curr.next;
                curr.next = null;
                break;
            }
            pre = pre.next;
            curr = curr.next;
        }
        return head;
    }
}
