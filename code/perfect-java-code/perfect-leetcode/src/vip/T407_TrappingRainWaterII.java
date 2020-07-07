package vip;

import java.util.PriorityQueue;

/**
 * @author Kelly
 * @create 2020-07-05 10:00
 *
 */
public class T407_TrappingRainWaterII {
    /**
     * 优先队列 + BFS
     * 用优先队列维护所有边界点，收缩时,上下左右四个方向收缩，维护一个visit的数组，记录哪些坐标已经被访问过
     * 先将最外圈节点入队.然后一圈圈遍历其邻居节点
     */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int n = heightMap.length, m = heightMap[0].length;  // 行和列
        boolean[][] visited = new boolean[n][m];  // 标记有没有被访问过

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[2] - b[2]));  // 根据高度排序

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    heap.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] directions = new int[]{-1, 0, 1, 0, -1};
        // 依次出队，进行 bfs
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            // 看周围的四个方向，如果没有访问过，可不可以灌水
            for (int k = 0; k < 4; k++) {
                int newX = poll[0] + directions[k];
                int newY = poll[1] + directions[k + 1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    // 若邻居高度小于“当前边界最小值”，则该邻居节点可储水(“当前边界最小值” - 邻居节点高度)
                    if (poll[2] > heightMap[newX][newY]) {
                        res += poll[2] - heightMap[newX][newY];
                    }
                    heap.offer(new int[]{newX, newY, Math.max(poll[2], heightMap[newX][newY])});
                    visited[newX][newY] = true;
                }

            }
        }
        return res;
    }
}
