package practice.tree;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-07-23 19:59
 */
public class T742_ClosestLeafInABinaryTree {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                visited.add(node);
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                // 叶子节点
                if (graph.get(node).size() <= 1) return node.val;
                for (TreeNode child : graph.get(node)) {
                    if (!visited.contains(child)) {
                        queue.add(child);
                        visited.add(child);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 树转无向图
     */
    private void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!graph.containsKey(node)) graph.put(node, new LinkedList<>());
        if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<>());
        graph.get(node).add(parent);
        graph.get(parent).add(node);
        dfs(graph, node.left, node);
        dfs(graph, node.right, node);
    }
}
