package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-13 09:18
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。
 * 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 */
public class T449_SerializeAndDeserializeBST {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = preOrder(root, new StringBuilder());
            sb.deleteCharAt(sb.length() - 1);  // 删除最后的空格
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] numStrs = data.split(",");
            return buildTree(numStrs, 0, numStrs.length);
        }

        public StringBuilder preOrder(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) return stringBuilder;
            stringBuilder.append(root.val);
            stringBuilder.append(",");
            preOrder(root.left, stringBuilder);
            preOrder(root.right, stringBuilder);
            return stringBuilder;
        }

        public TreeNode buildTree(String[] nums, int left, int right) {
            if (left > right) return null;
            TreeNode root = new TreeNode(Integer.parseInt(nums[left]));
            int index = right + 1;
            // 找到第一个比根节点大的树
            for (int i = left + 1; i < right; i++) {
                if (Integer.parseInt(nums[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            root.left = buildTree(nums, left + 1, index - 1);
            root.right = buildTree(nums, index, right);
            return root;
        }
    }
}
