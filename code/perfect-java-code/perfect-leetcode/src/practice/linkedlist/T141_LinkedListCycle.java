package practice.linkedlist;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-13 21:51
 */
public class T141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
