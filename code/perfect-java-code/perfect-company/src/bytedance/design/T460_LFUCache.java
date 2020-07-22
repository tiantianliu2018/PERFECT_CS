package bytedance.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-07-21 20:23
 *
 * 最不经常使用（LFU）缓存算法
 * 记录频率
 */
public class T460_LFUCache {
    class LFUCache {
        Map<Integer, ListNode> map;  // 节点 map
        Map<Integer, DoubleLinkedList> freqMap;
        int capacity;
        int minFreq;

        public LFUCache(int capacity) {
            map = new HashMap<>();
            freqMap = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 1;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int val = map.get(key).val;
            // 先删除，再放进去
            ListNode node = removeListNode(key);
            int freq = node.freq;
            addToFreqMapHead(freq, node);
            return val;
        }

        private void addToFreqMapHead(int freq, ListNode node) {
            if (freqMap.containsKey(freq)) {
                freqMap.get(freq).addFirst(node);
            } else {
                DoubleLinkedList list = new DoubleLinkedList();
                list.addFirst(node);
                freqMap.put(freq, list);
            }
        }

        private ListNode removeListNode(int key) {
            ListNode deletedNode = map.get(key);
            deletedNode.next.pre = deletedNode.pre;
            deletedNode.pre.next = deletedNode.next;
            deletedNode.pre = null;
            deletedNode.next = null;
            freqMap.get(deletedNode.freq).size--;
            // 维护最小频率
            if (deletedNode.freq == minFreq && freqMap.get(minFreq).size == 0) {
                minFreq++;
            }
            deletedNode.freq++;
            return deletedNode;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            ListNode node = map.get(key);
            // 原 map 不包含 node，要创建新的 node 加入进入
            if (node == null) {
                // 满了，删除最近最少使用的节点
                if (capacity == map.size()) {
                    ListNode deletedNode = freqMap.get(minFreq).removeTail();
                    map.remove(deletedNode.key);
                }
                // 创建新的节点，加入
                ListNode newNode = new ListNode(key, value);
                map.put(key, newNode);
                addToFreqMapHead(1, newNode);
                this.minFreq = 1;
            } else {
                // 直接覆盖
                node.val = value;
                ListNode listNode = removeListNode(key);
                listNode.val = value;
                addToFreqMapHead(listNode.freq, listNode);
            }
        }
    }
    class ListNode {
        int key;
        int val;
        int freq = 1;
        ListNode pre;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleLinkedList {
        private ListNode head;
        private ListNode tail;
        private int size;

        public DoubleLinkedList() {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(ListNode node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        public ListNode removeTail() {
            if (tail.pre == head) return null;
            ListNode last = tail.pre;
            ListNode secondLastNode = last.pre;
            secondLastNode.next = tail;
            tail.pre = secondLastNode;

            last.next = null;
            last.pre = null;
            size--;
            return last;
        }
    }
}
