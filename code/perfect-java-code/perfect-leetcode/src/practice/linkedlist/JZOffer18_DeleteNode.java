package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-10-23 09:54
 */
public class JZOffer18_DeleteNode {
    /**
     * 一个 pre 节点指向当前节点的前一个节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head.next = null;
            }
            head = head.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
