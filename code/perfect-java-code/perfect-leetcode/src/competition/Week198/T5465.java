package competition.Week198;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Kelly
 * @create 2020-07-19 10:37
 */
public class T5465 {
    class Solution2 {
        String labels;
        int[] res;

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            this.labels = labels;
            res = new int[n];
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            // 构建无向图的连接矩阵
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            boolean[] visited = new boolean[n];  // 记录哪些节点被访问过，哪些没有
            dfs(graph, 0, visited);
            return res;
        }
        // 统计子节点中每个字母出现的次数
        private int[] dfs(List<Integer>[] graph, int index, boolean[] visited) {
            int[] count = new int[26];
            count[labels.charAt(index) - 'a']++;
            visited[index] = true;
            // 遍历当前节点的相临边
            for (int next : graph[index]) {
                // 当前节点访问过了，限制只能向一个方向走
                if (visited[next]) continue;
                // DFS 访问每一个孩子节点
                int[] ret = dfs(graph, next, visited);
                for (int i = 0; i < 26; i++) {
                    count[i] += ret[i];
                }
            }
            // 更新最终的结果数组
            res[index] = count[labels.charAt(index) - 'a'];
            return count;
        }
    }
    static class Solution1 {
        /**
         * labels[i] - 第 i 个节点的标签
         */
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            int[] res = new int[n];
            // 建立邻接表
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            boolean[] visited = new boolean[n];
            visited[0] = true;
            dfs(res,0, graph, labels, visited);
            return res;
        }
        // 传入是第几个标签，找相同的节点
        private int[] dfs(int[] res, int index, List<Integer>[] graph, String labels, boolean[] visited) {
            int[] count = new int[26];
            char label = labels.charAt(index);
            count[label - 'a']++;
            for (int node : graph[index]) {
                if (visited[node]) continue;
                visited[node] = true;
                int[] ret = dfs(res, node, graph, labels, visited);
                for (int i = 0; i < 26; i++) {
                    count[i] += ret[i];
                }
            }
            res[index] = count[label - 'a'];
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,2},{0,3},{1,2}};
        String labels = "aeed";
        Solution1 s1 = new Solution1();
        int[] res = s1.countSubTrees(4, edges, labels);
        for (int i : res) {
            System.out.print(i + "\t");
        }
    }

}
