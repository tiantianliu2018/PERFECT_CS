package bytedance.tree;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-06-29 23:13
 */
public class LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 结果列表中现在有几层的数组
            int level = res.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    temp.add(node.val);
                } else {
                    temp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
