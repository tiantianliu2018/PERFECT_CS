package practice.linkedlist;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-25 21:19
 */
public class T234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        // 反转后半部分链表
        ListNode node = reverse(next);
        while (node != null && head != null) {
            if (node.val != head.val) return false;
            node = node.next;
            head = head.next;
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
