package meituan.T0829;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-29 16:24
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int XM = Integer.parseInt(s[1]);
        int XT = Integer.parseInt(s[2]);
        // 建图
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; i++) {
            s = in.nextLine().split(" ");
            graph[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            graph[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }
        //

    }
}
