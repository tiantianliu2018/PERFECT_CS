package meituan;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-15 16:02
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashSet<String> set = new HashSet<>();
        List<String[]> saved = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        int unique = 0;
        for (int i = 0; i < n; i++) {
            String[] edge = in.nextLine().split(" ");
            saved.add(edge);
            if (!set.contains(edge[0])) {
                unique++;
                set.add(edge[0]);
            }
//            graph[unique].add()
            if (!set.contains(edge[1])) {
                unique++;
                set.add(edge[1]);
            }

        }


    }
}
