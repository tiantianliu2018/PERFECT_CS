package practice.tree;

/**
 * @author Kelly
 * @create 2020-07-11 11:16
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class T968_BinaryTreeCameras {
    /**
     * 每个节点三个状态：
     * 0 -- 未被覆盖；
     * 1 -- 已被覆盖，但不是自己的相机；
     * 2 -- 已经安装了相机
     */
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) res++;
        return res;
    }
    // 后序遍历
    private int dfs(TreeNode root) {
        if (root == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 左右孩子中有一个没有被覆盖，当前节点要安装摄像头，并标记状态为 2
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // 左右孩子都已覆盖，则当前节点未被覆盖，标记状态为 0
        if (left == 1 && right == 1) {
            return 0;
        }
        // 若左右孩子有一个放置了摄像头，当前节点已经被覆盖
        if (left + right >= 3) return 1;
        return -1;
    }
}
