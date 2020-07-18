package bytedance.dfs;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-07-15 21:43
 */
public class T886_PossibleBipartition {
    // DFS
    class Solution1 {
        ArrayList<Integer>[] graph;
        Map<Integer, Integer> color;

        public boolean possibleBipartition(int N, int[][] dislikes) {
            if (N < 2 || dislikes.length == 0) return false;
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : dislikes) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            color = new HashMap<>();
            for (int node = 1; node <= N; node++) {
                // 没分组，并且其“讨厌的人” 只能和他染相同的颜色
                if (!color.containsKey(node) && !dfs(node, 0)) {
                    return false;
                }
            }
            return true;
        }
        public boolean dfs(int node, int c) {
            if (color.containsKey(node)) {
                return color.get(node) == c;
            }
            color.put(node, c);  // 上色
            // 深度遍历当前节点的邻居节点
            for (int neighbor : graph[node]) {
                // 邻居节点不能染其他颜色
                if (!dfs(neighbor, c ^ 1)) return false;
            }
            return true;
        }
    }

    // BFS
    class Solution2 {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            List<Set<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new HashSet<>());
            }
            for (int[] edge : dislikes) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            int[] colors = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                // 染过色, 继续
                if (colors[i] != 0) {
                    continue;
                }
                // 若没有染过色，尝试对其染色，并看能否将邻居节点染不同的颜色
                colors[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    int color = colors[curr];
                    for (int neighbor : graph.get(curr)) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -color;
                            queue.add(neighbor);
                        } else if (colors[neighbor] == color) {  // 邻居节点和当前节点的颜色相同
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    // 并查集
    class Solution3 {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            UnionFind uf = new UnionFind(2 * N + 1);
            for (int i = 0; i < dislikes.length; i++) {
                int x = uf.find(dislikes[i][0]);    // 自己的根节点
                int y = uf.find(dislikes[i][1]);    // 不喜欢人的根节点
                int a = uf.find(dislikes[i][0] + N);
                int b = uf.find(dislikes[i][1] + N);
                if (x == y) return false;
                else {
                    uf.union(x, b);
                    uf.union(y, a);
                }
            }
            return true;
        }
    }
    class UnionFind {
        int[] parent;
        // 连通分量的个数
        int count;

        UnionFind(int N) {
            this.count = N;
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                count--;
            }
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

}
