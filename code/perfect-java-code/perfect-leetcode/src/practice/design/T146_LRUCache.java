package practice.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-08-31 15:25
 */
public class T146_LRUCache {
    // 直接用现有的 LinkedList
    class LRUCache {
        Map<Integer, Integer> map;
        LinkedList<Integer> list;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            this.capacity = capacity;
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
            } else {
                if (capacity == list.size()) {
                    Integer first = list.removeFirst();
                    map.remove(first);
                }
            }
            map.put(key, value);
            list.addLast(key);
        }
    }

    class LRUCache2 {
        Map<Integer, Node> map;
        DoubleList list;
        int capacity;

        public LRUCache2(int capacity) {
            map = new HashMap<>();
            list = new DoubleList();
            capacity = this.capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            if (map.containsKey(key)) {
                list.remove(map.get(key));
            } else {
                if (capacity == list.size) {
                    Node last = list.removeLast();
                    map.remove(last.key);
                }
            }
            list.addFirst(newNode);
            map.put(key, newNode);
        }
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
        class DoubleList {
            Node head, tail;
            int size;

            public DoubleList() {
                head = new Node(0,0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
                this.size = 0;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                head.next = node;
                node.next.pre = node;
                node.pre = head;
                size++;
            }

            public void remove(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
                size--;
            }

            public Node removeLast() {
                if (tail.pre == head) return null;
                Node last = tail.pre;
                remove(last);
                return last;
            }
        }
    }
}
