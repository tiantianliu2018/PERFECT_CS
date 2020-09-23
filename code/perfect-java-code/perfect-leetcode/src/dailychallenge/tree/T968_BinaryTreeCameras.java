package dailychallenge.tree;

/**
 * @author Kelly
 * @create 2020-09-22 08:57
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class T968_BinaryTreeCameras {
    /**
     * 树上的状态转移
     * 节点有三种状态：
     * 未被覆盖   0
     * 已被覆盖，但不是在当前节点安装摄像头  1
     * 在当前节点安装摄像头  2
     */
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (dfs(root) == 0) res++;
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 左子树、右子树中有一个没有被覆盖，则在当前节点安装摄像头，为了覆盖左右子树
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 如果左右子树均被覆盖，但是不是在左右子树的任何一个安装的摄像头，那么当前节点不会被覆盖
        if (left == 1 && right == 1) {
            return 0;
        }
        // 如果左右子树中有一个安装了摄像头，那么当前节点一定可以被覆盖
        if (left + right >= 3) {
            return 1;
        }
        return -1;
    }

}
