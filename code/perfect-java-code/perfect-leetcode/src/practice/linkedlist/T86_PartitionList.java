package practice.linkedlist;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-15 11:28
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class T86_PartitionList {
    /**
     * 分别新建一个大于 x 和小于 x 的链表
     * 遍历总链表，进行拆分，最后组合
     */
    public ListNode partition(ListNode head, int x) {
        ListNode bigDummy = new ListNode(0);
        ListNode bigCurr = bigDummy;
        ListNode smallDummy = new ListNode(0);
        ListNode smallCurr = smallDummy;
        while (head != null) {
            if (head.val < x) {
                smallCurr.next = new ListNode(head.val);
                smallCurr = smallCurr.next;
            } else {
                bigCurr.next = new ListNode(head.val);
                bigCurr = bigCurr.next;
            }
            head = head.next;
        }
        smallCurr.next = bigDummy.next;
        return smallDummy.next;
    }
}
