package practice.dfs;

import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-31 08:30
 */
public class T841_KeysAndRooms {
    public static void main(String[] args) {

    }

    /**
     * boolean visited[n] 标记是否访问过，最后用来遍历
     * 根据每一个房间的钥匙列表，访问对应的房间
     * @param rooms
     * @return
     */
    int trueCount = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        return trueCount == n;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int idx) {
        visited[idx] = true;
        trueCount++;
        for (int key : rooms.get(idx)) {
            if (!visited[key]) {
                dfs(rooms, visited, key);
            }
        }
    }
}
