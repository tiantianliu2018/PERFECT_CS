package practice.tree.Trie;

/**
 * @author Kelly
 * @create 2020-09-10 09:24
 *
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。
 * 字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 */
public class T677_MapSumPairs {
    class MapSum {
        private Node root;
        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node node = root;
            char[] charArray = key.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int idx = charArray[i] - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            // 遍历结束
            node.value = val;
        }

        public int sum(String prefix) {
            if (prefix == null) return 0;
            Node node = root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int idx = charArray[i] - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return dfs(node);
        }

        private int dfs(Node node) {
            if (node == null) return 0;
            int res = node.value;
            for (Node child : node.children) {
                res += dfs(child);
            }
            return res;
        }

        class Node {
            Node[] children;
            int value;
            public Node() {
                children = new Node[26];
            }
        }
    }

}
