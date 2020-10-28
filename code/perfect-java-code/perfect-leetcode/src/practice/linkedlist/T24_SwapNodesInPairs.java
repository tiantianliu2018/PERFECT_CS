package practice.linkedlist;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-03 10:16
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class T24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        while (curr != null && curr.next != null) {
            pre.next = curr.next;
            curr.next = curr.next.next;
            pre.next.next = curr;
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
