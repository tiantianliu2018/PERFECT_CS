package backtrack;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-08-11 19:00
 */
public class T13_MovingCount {
    /**
     * DFS 思路
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    private int dfs(int m, int n, int k, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || bitSum(x) + bitSum(y) > k) return 0;
        visited[x][y] = true;
        // dfs 只向下，向右移动, 1 是当前位置
        return dfs(m, n, k, visited,x + 1, y) + dfs(m, n, k, visited, x, y + 1) + 1;
    }
    // 求每一位的和
    private int bitSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    /**
     * BFS
     */
    public int movingCount1(int m, int n, int k) {
        if (k == 0) return 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}};
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction : directions) {
                int newX = curr[0] + direction[0];
                int newY = curr[1] + direction[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || bitSum(newX) + bitSum(newY) > k) continue;
                queue.add(new int[]{newX, newY});
                res++;
                visited[newX][newY] = true;
            }
        }
        return res;
=======
public class T13_MovingCount {
    public int movingCount(int m, int n, int k) {

>>>>>>> ce7d2a6ac831b026408983085b541c36b2d84960
    }
}
