package practice.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelly
 * @create 2020-08-15 10:05
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 */
public class T200_NumberOfIslands {
    /**
     * 从陆地开始进行 DFS
     */
    int n, m;
    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 超出范围，后者是海洋，直接返回
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
        // 将海洋标为陆地
        grid[i][j] = '0';
        // 搜索四个方向
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }

    /**
     * BFS
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                res++;
                // 借助原矩阵进行访问标记
                grid[i][j] = '0';
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for (int[] direction : directions) {
                        int newX = curr[0] + direction[0];
                        int newY = curr[1] + direction[1];
                        if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == '0') continue;
                        queue.add(new int[]{newX, newY});
                        grid[newX][newY] = '0';
                    }
                }
            }
        }
        return res;
    }
}
