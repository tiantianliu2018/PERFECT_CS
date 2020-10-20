package dailychallenge.linkedlist;

/**
 * @author Kelly
 * @create 2020-10-20 14:04
 */
public class T143_ReorderList {
    /**
     * 重排链表
     * 1. 快慢指针找中点
     * 2. 反转后半部分
     * 3. 重新连接合并
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null; // 断开两部分链表
        ListNode node = reverse(next);
        ListNode curr = head;
        while (node != null) {
            next = node.next;
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
            node = next;
        }
    }
    // 反转链表
    private ListNode reverse(ListNode node) {
        ListNode pre = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
