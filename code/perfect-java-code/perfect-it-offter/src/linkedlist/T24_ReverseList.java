package linkedlist;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class T24_ReverseList {
    /**
     * 递归方法
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 递归反转了除头结点以外的链表
        ListNode node = reverseList(head.next);
        // 将头结点接到翻转链表的后面
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 迭代方法
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
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
