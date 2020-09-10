package wangyi;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-09-05 15:39
 */
public class solution3 {
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        // 测试用例个数
        for (int t = 0; t < T; t++) {
            // move 操作的个数
            int N = Integer.parseInt(in.nextLine());
            int x = 0, y = 0;
            Set<Pos> visited = new HashSet<>();
            visited.add(new Pos(0, 0));
            for (int i = 0; i < N; i++) {
                String[] s = in.nextLine().split(" ");
                int direction = Integer.parseInt(s[0]);
                int success = Integer.parseInt(s[1]);
                if (success == 1) {  // 成功
                    if (direction == 0) {
                        y -= 1;
                    } else if (direction == 1) {
                        y += 1;
                    } else if (direction == 2) {
                        x -= 1;
                    } else if (direction == 3) {
                        x += 1;
                    }
                    visited.add(new Pos(x, y));
                }
            }
            int res = bfs(x, y, visited);
            //dfs(0, 0, x, y, visited);
            System.out.println(res);
        }
    }

    private static void dfs(int x, int y, int targetX, int targetY, Set<Pos> visited) {
        if (x == targetX && y == targetY) return;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            Pos newPos = new Pos(newX, newY);
            if (visited.contains(newPos)) {
                ans++;
                dfs(newX, newY, targetX, targetY, visited);
            }
        }
    }

    private static int bfs(int x, int y, Set<Pos> visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = pos[0] + directions[i][0];
                int newY = pos[1] + directions[i][1];
                if (newX == x && newY == y) {
                    res += 1;
                    return res;
                }
                Pos position = new Pos(newX, newY);
                if (visited.contains(position)) {
                    queue.add(new int[]{newX, newY});
                }
            }
            res++;
        }
        return res;
    }
}
