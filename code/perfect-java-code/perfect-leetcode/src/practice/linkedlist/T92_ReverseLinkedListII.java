package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-07-10 09:13
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 关键是记住位置 m 的前一个节点和位置 n 的后一个节点
 * 题目中 m 和 n 一定是合法的
 */
public class T92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 要反转链表的头结点
        ListNode start = pre.next;
        // 找到第 n 个节点
        ListNode curr = start;
        for (int i = m; i < n; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;  // 记下反转后要连接的下一个位置
        ListNode node = reverse(start, next);
        pre.next = node;
        start.next = next;
        return dummy.next;
    }
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null, curr = start, next = null;
        while (curr != end) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
