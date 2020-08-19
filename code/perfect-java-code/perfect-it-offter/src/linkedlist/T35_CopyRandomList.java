package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class T35_CopyRandomList {
    /**
     * 用 map 辅助存储
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node node = head;
        // 遍历链表，将复制节点与原节点的相对应关系存到 hashmap
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     * 直接复制链表中的节点，放在原来节点的后面
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        // 复制节点，将其接在原节点的后面
        Node node = head;
        while (node != null) {
            // 新复制一个节点，放在当前节点的后面
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            // 指针移动
            node = newNode.next;
        }
        // 链接 random 指针
        node = head;
        Node temp;
        while (node != null) {
            temp = node.next;
            if (node.random != null) {
                temp.random = node.random.next;
            }
            node = temp.next;
        }
        // 拆分链表
        Node newHead = head.next, curr = newHead;
        node = head;
        while (node != null) {
            node.next = node.next.next;
            node = node.next;
            if (curr.next != null) {
                curr.next = curr.next.next;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
