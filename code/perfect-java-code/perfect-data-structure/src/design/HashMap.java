package design;


import java.util.Iterator;

public class HashMap<K, V> {
    class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;
        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
    private Node<K,V>[] table;
    private int size;

    public HashMap(int capacity) {
        table = new Node[capacity];
    }

    // 添加元素
    public void put(K key, V value) {
        int hash = hash(key);
        // 计算元素在 table 中的位置
        int index = hash & (table.length - 1);
        Node<K, V> firstNode = table[index];
        // 当前位置没有元素
        if (firstNode == null) {
            table[index] = new Node<>(hash, key, value);
            size++;
        } else {
            // 判断是不是
            Node<K, V> currNode = firstNode;
            // 当前 key 不相同
            while (currNode.next != null && !currNode.key.equals(key)) {
                currNode = currNode.next;
            }
            // 退出循环，走到了最后一个节点，或者 key 相等
            // key 相等，对原值进行覆盖
            if (currNode.next != null) {
                currNode.value = value;
            } else if (currNode.next == null && currNode.key.equals(key)) {
                // 走到了空节点，并且要添加的节点的 key 等于最后一个节点
                currNode.value = value;
            } else {
                currNode.next = new Node<>(hash, key, value);
                size++;
            }
        }
    }

    // hash 函数
    private int hash(K key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

    // 查找函数
    public V get(K key) {
        int hash = hash(key);
        int index = hash & (table.length - 1);
        Node<K, V> firstNode = table[index];
        if (firstNode == null) {
            return null;
        } else {
            // 遍历链表，拿到节点
            Node<K, V> currNode = firstNode;
            while (currNode != null) {
                if (currNode.key.equals(key) && currNode.hash == hash) {
                    return currNode.value;
                }
                currNode = currNode.next;
            }
        }
        return null;
    }

    // 删除函数
    public boolean remove(K key) {
        int hash = hash(key);
        int index = hash & (table.length - 1);
        Node<K, V> firstNode = table[index];
        if (firstNode == null) {
            return false;
        } else {
            // 删除的是第一个节点
            if (firstNode.key.equals(key) && firstNode.hash == hash) {
                table[index] = firstNode.next;
                return true;
            } else {
                // 不是第一个节点
                Node<K, V> currNode = firstNode;
                while (currNode.next != null) {
                    if (currNode.next.key.equals(key) && currNode.next.hash == hash) {
                        currNode.next = currNode.next.next;
                        return true;
                    } else {
                        currNode = currNode.next;
                    }
                }
                return false;
            }
        }
    }

    // 扩容
    public void resize() {
        Node<K, V>[] newTable = new Node[this.table.length * 2];
        for (int i = 0; i < this.table.length; i++) {
            // 对原来 table 中的每一个节点 rehash
            rehash(i, newTable);
        }
        this.table = newTable;
    }

    private void rehash(int index, Node<K, V>[] newTable) {
        Node<K, V> currNode = table[index];
        if (currNode == null) {
            return;
        }
        Node<K, V> lowHead = null;
        Node<K, V> lowTail = null;
        Node<K, V> highHead = null;
        Node<K, V> highTail = null;
        while (currNode != null) {
            int newIndex = hash(currNode.key) & (newTable.length - 1);
            if (newIndex == index) {
                // 新的位置和原来的位置相同
                if (lowHead == null) {
                    lowHead = currNode;
                    lowTail = currNode;
                } else {
                    lowTail.next = currNode;
                    lowTail = lowTail.next;
                }
            } else {
                if (highHead == null) {
                    highHead = currNode;
                    highTail = currNode;
                } else {
                    highTail.next = currNode;
                    highTail = highTail.next;
                }
            }
            currNode = currNode.next;
        }
        // 将 index 位置连上当前的 lowList
        if (lowTail != null) {
            lowHead.next = null;
            newTable[index] = lowHead;
        }
        // 将 index + table.length 位置上连上 highList
        if (highTail != null) {
            highTail.next = null;
            newTable[index + this.table.length] = highHead;
        }
    }

    // 迭代器
    public Iterator<Node<K, V>> iterator() {
        return new Itr();
    }

    class Itr implements Iterator<Node<K, V>> {
        private Node<K, V> nextNode;
        private Node<K, V> currNode;
        private int currIndex;

        public Itr() {
            if (HashMap.this.size == 0) {
                return;
            }
            for (int i = 0; i < HashMap.this.table.length; i++) {
                if (table[i] != null) {
                    this.nextNode = table[i];
                    this.currIndex = i;
                    return;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Node<K, V> next() {
            this.currNode = nextNode;
            this.nextNode = nextNode.next;
            if (this.nextNode == null) {
                // 表明当前位置的链表已经遍历完成
                for (int i = currIndex + 1; i < HashMap.this.table.length; i++) {
                    if (table[i] != null) {
                        this.nextNode = table[i];
                        this.currIndex = i;
                        break;
                    }
                }
            }
            return currNode;
        }
    }
}
