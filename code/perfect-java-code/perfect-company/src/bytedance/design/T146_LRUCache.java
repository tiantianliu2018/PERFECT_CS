package bytedance.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-07-17 09:23
 */
public class T146_LRUCache {
    /**
     * Map + LinkedList
     */
    class LRUCache {
        Map<Integer, Integer> map;
        LinkedList<Integer> list;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key);
            list.remove((Integer) key);
            list.addLast(key);
            return val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
            } else if (list.size() == capacity) {
                // 移除最近未使用
                Integer first = list.removeFirst();
                map.remove(first);
            }
            list.addLast(key);
            map.put(key, value);
        }
    }

    /**
     * 手写双向链表
     */
    class LRUCache1 {
        Map<Integer, Node> map;
        DoubleList list;
        int capacity;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        //
        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            // 包含要放入的节点，则更新
            if (map.containsKey(key)) {
                Node node = map.get(key);
                list.remove(node);
            } else if (list.size == capacity){  // 满了
                // 满了，删除最近最久未使用的
                Node last = list.removeLast();  // 双链表删除
                map.remove(last.key);  // map 删除
            }
            list.addFirst(newNode);
            map.put(key, newNode);
        }


        // 定义链表的节点
        class Node {
            int key;
            int val;
            Node pre;
            Node next;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
            }
        }

        // 定义双向链表
        class DoubleList {
            Node head;
            Node tail;
            int size;

            public DoubleList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
                size = 0;
            }

            // 插入链表头
            public void addFirst(Node node) {
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
                size++;
            }

            // 删除 node 节点
            public void remove(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                size--;
            }

            // 删除链表的最后一个节点
            public Node removeLast() {
                if (tail.pre == head) return null;
                Node last = tail.pre;
                remove(last);
                return last;
            }
        }
    }
}
