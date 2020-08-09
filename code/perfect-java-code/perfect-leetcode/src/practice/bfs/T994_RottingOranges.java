package practice.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-07-25 18:16
 *
 * 图的 BFS
 */
public class T994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        // 新鲜橘子的个数
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
                // 累计新鲜橘子的个数
                if (grid[i][j] == 1) fresh++;
            }
        }
        // 感染时间
        int time = 0;
        while (queue.isEmpty()) {
            int[] poll = queue.poll();
            time = poll[2];
            for (int[] direction : directions) {
                int newX = poll[0] + direction[0];
                int newY = poll[1] + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    fresh--;
                    queue.add(new int[]{newX, newY, time + 1});
                }
            }
        }
        if (fresh > 0) return -1;
        return time;
    }
}
