package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-10-23 10:38
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class T19_RemoveNthNodeFromEndOfList {
    /**
     * 删除倒数第 n 个节点，就是找到倒数第 n+1 个节点是哪个节点，然后将该节点链接倒数 n-1 个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;  // slow 指向要删除节点的前一个
        return head;
    }
}
