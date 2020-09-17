package dailychallenge.graph;

/**
 * @author Kelly
 * @create 2020-09-17 10:26
 */
public class T685_RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n + 1);
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (unionFind.find(node1) == unionFind.find(node2)) {
                    cycle = i;
                } else {
                    unionFind.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            return edges[cycle];
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle < 0) {
                return conflictEdge;
            } else {
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            }
        }
    }
    class UnionFind {
        int[] root;
        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int p) {
            // 如果父节点不等于当前节点，一直向上找
            while (root[p] != p) {
                p = root[root[p]];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                root[pRoot] = qRoot;
            }
        }
    }
}
