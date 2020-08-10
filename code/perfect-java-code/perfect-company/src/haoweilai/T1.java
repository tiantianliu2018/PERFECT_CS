package haoweilai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-08-08 10:44
 */
public class T1 {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int rootVal = Integer.parseInt(s[1]);
        TreeNode root = new TreeNode(rootVal);
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            arr[Integer.parseInt(s[0])][0] = Integer.parseInt(s[1]);
            arr[Integer.parseInt(s[0])][1] = Integer.parseInt(s[2]);
        }
        buildTree(root, arr);
        printByLevel(root);
        System.out.println();
        printByZigZag(root);
    }

    private static void printByZigZag(TreeNode root) {
    }

    private static void printByLevel(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        System.out.println("Level " + level++ + ":");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
        }
    }

    public static void buildTree(TreeNode root, int[][] arr) {
        if (root == null) return;
        if (arr[root.val][0] != 0) {
            root.left = new TreeNode(arr[root.val][0]);
            buildTree(root.left, arr);
        }
        if (arr[root.val][1] != 0) {
            root.right = new TreeNode(arr[root.val][1]);
            buildTree(root.right, arr);
        }
    }
}
