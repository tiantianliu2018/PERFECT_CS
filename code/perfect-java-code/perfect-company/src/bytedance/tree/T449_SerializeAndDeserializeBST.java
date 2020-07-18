package bytedance.tree;

import bytedance.linkedlist.ListNode;

/**
 * @author Kelly
 * @create 2020-07-15 23:55
 */
public class T449_SerializeAndDeserializeBST {
    /**
     * 前序遍历对二叉树进行序列化
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] numArr = data.split(",");
        return buildTree(numArr, 0, numArr.length - 1);
    }

    private TreeNode buildTree(String[] arr, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[start]));
        int index = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (Integer.parseInt(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        root.left = buildTree(arr, start + 1, index - 1);
        root.right = buildTree(arr, index, end);
        return root;
    }
}
