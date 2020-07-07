package bytedance.linkedlist;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-06-30 09:15
 *
 * 数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 7 -> 8 -> 0 -> 7
 *
 * 最简单的想法，就是将链表进行反转，然后跟 T2 一样相加，再反转回来，但是这里要求不要进行链表的改变
 */
public class T445_AddTwoNumbersII {
    /**
     * 先考虑链表反转的做法
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        ListNode newHead = reverse(dummy.next);
        return newHead;
    }

    /**
     * 反转链表
     */
    public ListNode reverse(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 不使用链表反转，因为反转链表相当于栈，所以可以借助栈来完成
     * 用栈保存链表的节点
     * 再从栈中取数，相加
     **/
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 头插法，返回结果链表
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }

}
