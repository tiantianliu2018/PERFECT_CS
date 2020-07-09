package bytedance.linkedlist;

/**
 * @author Kelly
 * @create 2020-07-08 19:13
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 */
public class T25_ReverseNodesInkGroup {
    /**
     * k 个一组分成链表，迭代法
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = pre;
        while (head != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode next = tail.next;  // 记录下下次要反转的位置
            tail.next = null;  // 断开链表

            ListNode node = reverse(head);  // 反转链表
            // 修改指针
            pre.next = node;
            head.next = next;
            pre = head;
            head = next;
            tail = pre;
        }
        return dummy.next;
    }

    // 链表的反转
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

    /**
     * 递归法
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode start = head, tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;  // 不足 k 个节点，直接返回头结点
            tail = tail.next;
        }
        ListNode node = reverseKGroup(tail, k);  // 反转后面链表的结果
        // 反转前 k 个节点
        ListNode newHead = reverseLinkedList(start, tail);
        start.next = node;
        return newHead;
    }

    public ListNode reverseLinkedList(ListNode start, ListNode end) {
        ListNode pre = null, next = null;
        while (start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        return pre;
    }
}
