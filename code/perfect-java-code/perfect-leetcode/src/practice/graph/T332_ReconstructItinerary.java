package practice.graph;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-27 09:48
 */
public class T332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return res;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> neighbor = graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>());
            neighbor.add(ticket.get(1));
        }
        graph.values().forEach(x -> x.sort(String::compareTo));
        dfs(graph, "JFK", res);
        return res;
    }

    private void dfs(Map<String, List<String>> graph, String start, List<String> res) {
        List<String> neighbor = graph.get(start);
        while (neighbor != null && neighbor.size() > 0) {
            String dest = neighbor.remove(0);
            dfs(graph, dest, res);
        }
        res.add(0, start);
    }

    public List<String> findItinerary1(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return res;
        // 建图
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> neighbor = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            neighbor.offer(ticket.get(1));
        }
        // dfs
        dfs2(graph, "JFK", res);
        return res;
    }

    private void dfs2(Map<String, PriorityQueue<String>> graph, String src, List<String> res) {
        PriorityQueue<String> neighbor = graph.get(src);
        while (neighbor != null && neighbor.size() > 0) {
            // 删除这个邻接关系
            String dest = neighbor.poll();
            dfs2(graph, dest, res);
        }
        res.add(0, src);
    }
}
