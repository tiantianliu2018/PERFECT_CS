package practice.tree.Trie;

/**
 * @author Kelly
 * @create 2020-09-10 08:56
 *
 * 构建前缀树
 */
public class T208_ImplementTrie {
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) return;
            char[] charArray = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < charArray.length; i++) {
                int idx = charArray[i] - 'a';
                if (node.children[idx] == null) {
                    // 该节点之前未插入过
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            // 遍历完单词的每一个字符，走到了单词结尾
            node.isLeaf = true;
        }

        // 搜索一个单词是否在字典树中存在
        public boolean search(String word) {
            if (word == null) return false;
            char[] charArray = word.toCharArray();
            TrieNode node = root; // 从 root 开始搜索
            for (int i = 0; i < charArray.length; i++) {
                int idx = charArray[i] - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx]; // 继续向下搜索
            }
            // 看是否走到了叶子节点
            return node.isLeaf;
        }
        // 判断字典树中是否包含某个单词的前缀
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;
            TrieNode node = root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int idx = charArray[i] - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return true;
        }


        class TrieNode {
            TrieNode[] children;
            boolean isLeaf;
            public TrieNode() {
                children = new TrieNode[26];
            }
        }
    }
}
