package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-09-03 10:29
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class T328_OddEvenLinkedList {
    /**
     * 遍历链表，奇节点放一起，偶节点放一起
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    // 拆成两部分，再链接到一起
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;  // 分别指向奇数节点和偶数节点
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
