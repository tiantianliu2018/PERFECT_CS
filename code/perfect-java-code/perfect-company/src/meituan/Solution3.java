package meituan;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-15 16:02
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            s = in.nextLine().split( " ");
            if (s[0].equals(s[1])) continue;
            graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }
        // BFS 看几个小区
        boolean[] visited = new boolean[graph.size()];
        int res = 0;
        int v = 0;
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            res++;
            visited[i] = true;
            v++;
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbor : graph.get(curr)) {
                    if (visited[neighbor]) continue;
                    queue.add(neighbor);
                    temp.add(neighbor);
                    visited[neighbor] = true;
                    v++;
                }
            }
            resList.add(temp);
            if (v == m) break;
        }

        System.out.println(res);
        for (List<Integer> list : resList) {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }


}
