package bytedance.tree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-07-18 10:23
 */
public class T297_SerializeAndDeserializeBinaryTree {
    // 前序遍历 递归
    class Solution1 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        public void preOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            } else {
                sb.append(root.val);
            }
            sb.append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] strs = data.split(",");
            List<String> list = new LinkedList<>(Arrays.asList(strs));
            return buildTree(list);
        }

        private TreeNode buildTree(List<String> list) {
            if (list.get(0).equals("#")) {
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            root.left = buildTree(list);
            root.right = buildTree(list);
            return root;
        }
    }

    /**
     * BFS 层次遍历
     */
    class Solution2 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            bfs(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void bfs(TreeNode root, StringBuilder sb) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("#,");
                }
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] strings = data.split(",");
            return buildTree(strings);
        }

        private TreeNode buildTree(String[] strings) {
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (strings[index].equals("#")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(strings[index]));
                    queue.offer(node.left);
                }
                index++;
                if (strings[index].equals("#")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(strings[index]));
                    queue.offer(node.right);
                }
                index++;
            }
            return root;
        }
    }

}
