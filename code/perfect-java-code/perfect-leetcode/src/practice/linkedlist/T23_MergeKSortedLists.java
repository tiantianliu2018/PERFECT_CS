package practice.linkedlist;

import java.util.PriorityQueue;

/**
 * @author Kelly
 * @create 2020-07-09 20:04
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class T23_MergeKSortedLists {
    /**
     * 通过将首节点放在堆当中，利用堆来排序
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // 小顶堆
        PriorityQueue<ListNode> nodeHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));  // 默认小顶堆
        ListNode dummy = new ListNode(0), curr = dummy;
        // 将所有链表的首节点放在堆中
        for (ListNode list : lists) {
            if (list != null) nodeHeap.offer(list);
        }
        // 只要堆不为空
        while (!nodeHeap.isEmpty()) {
            // 取一个节点，并判断是否还有后序节点
            ListNode node = nodeHeap.poll();
            if (node.next != null) nodeHeap.offer(node.next);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * 两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoList(lists[i], lists[n - 1 - i]);
            }
            n = (n + 1) / 2;  // 取上整，防止漏掉
        }
        return lists[0];
    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        return dummy.next;
    }

    // 再次练习
    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(n, (a, b) -> (a.val - b.val));
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) heap.offer(lists[i]);
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
