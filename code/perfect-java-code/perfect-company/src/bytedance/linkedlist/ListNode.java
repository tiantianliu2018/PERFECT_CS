package bytedance.linkedlist;

/**
 * @author Kelly
 * @create 2020-07-15 19:26
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
