package dailychallenge.linkedlist;

/**
 * @author Kelly
 * @create 2020-10-20 14:05
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
