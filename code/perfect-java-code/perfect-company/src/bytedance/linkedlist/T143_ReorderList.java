package bytedance.linkedlist;

/**
 * @author Kelly
 * @create 2020-07-15 19:25
 *
 * 经典的链表题目，考查很全面
 */
public class T143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;  // 记下后半段的头结点
        slow.next = null;     // 断开链表
        // 反转链表
        ListNode node = reverse(next);
        // 两个链表归并
        ListNode curr = head;
        while (node != null) {
            next = curr.next;
            curr.next = node;
            node = node.next;
            curr.next.next = next;
            curr = next;
        }
        return;
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
