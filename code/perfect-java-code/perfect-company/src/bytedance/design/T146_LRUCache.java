package bytedance.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-07-17 09:23
 */
public class T146_LRUCache {
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
}
