package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历序列化二叉树，遇到 null, 用 # 表示
 */
public class T37_SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    // 前序遍历，遇到空节点，用 # 表示
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");
        // 用链表存储各个节点的值，便于 remove
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return buildTree(list);
    }

    private TreeNode buildTree(List<String> list) {
        if (list.get(0).equals("#")) {
            // 如果遇到空节点
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
