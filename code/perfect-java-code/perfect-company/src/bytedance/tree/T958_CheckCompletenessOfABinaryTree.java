package bytedance.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-07-22 19:47
 */
public class T958_CheckCompletenessOfABinaryTree {
    /**
     * 层次遍历，只要出现了空节点，并且后面还有节点，就不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 标记是否出现过 null
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (flag) return false;
                queue.add(node.left);
                queue.add(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }
}
