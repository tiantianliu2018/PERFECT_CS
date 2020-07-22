package bytedance.linkedlist;

/**
 * @author Kelly
 * @create 2020-07-19 13:50
 */
public class T25_ReverseNodesInkGroup {
    // 迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (tail == null) break;
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode next = tail.next;  // 记下下一个位置
            tail.next = null;

            ListNode node = reverse(head);
            pre.next = node;
            head.next = next;
            pre = head;
            head = next;
            tail = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
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
