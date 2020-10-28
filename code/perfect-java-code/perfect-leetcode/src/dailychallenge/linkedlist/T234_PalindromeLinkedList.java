package dailychallenge.linkedlist;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-10-23 09:05
 * 请判断一个链表是否为回文链表。
 */
public class T234_PalindromeLinkedList {
    /**
     * 快慢指针找到中点，反转后半部分链表，然后两部分逐一对比。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode node = reverse(next);
        while (head != null) {
            if (head.val != node.val) return false;
            head = head.next;
            node = node.next;
        }
        return true;
    }

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
