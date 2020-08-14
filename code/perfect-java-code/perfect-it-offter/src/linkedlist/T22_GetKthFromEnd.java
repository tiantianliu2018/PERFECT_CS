package linkedlist;

/**
 * 返回链表的倒数第 k 个节点
 * 输入一个链表，输出该链表中倒数第 k个节点。为了符合大多数人的习惯，本题从 1开始计数，即链表的尾节点是倒数第 1个节点。
 */
public class T22_GetKthFromEnd {
    /**
     * 设置两个指针，一个指针先走 k 步，然后一起走，直到先走的指针走到了 null
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        // 说明 k 大于链表的长度
        if (k != 0) return null;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
