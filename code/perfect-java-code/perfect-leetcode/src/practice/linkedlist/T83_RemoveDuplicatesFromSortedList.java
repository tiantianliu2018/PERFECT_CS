package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-10-23 10:19
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class T83_RemoveDuplicatesFromSortedList {
    /**
     * 链表已经是排好序的，因此可以直接遍历链表，对比 next 是否和 curr 相同，若相同，删除 next(直接链接到下下个节点）
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
