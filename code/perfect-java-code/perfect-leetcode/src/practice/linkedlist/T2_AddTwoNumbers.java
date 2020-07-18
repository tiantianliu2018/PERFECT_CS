package practice.linkedlist;

/**
 * @author Kelly
 * @create 2020-06-30 09:05
 *
 * 这道题目没有反转最后的结果，所以比较简单
 */
public class T2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        // 额外的头结点
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null || carry != 0){
             int x = (l1 == null) ? 0 : l1.val;
             int y = (l2 == null) ? 0 : l2.val;
             int sum = x + y + carry;
             carry = sum / 10;
             curr.next = new ListNode(sum % 10);
             if (l1 != null) l1 = l1.next;
             if (l2 != null) l2 = l2.next;
             curr = curr.next;
        }
        return dummy.next;
    }
}
