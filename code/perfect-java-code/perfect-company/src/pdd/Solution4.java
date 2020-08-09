package pdd;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 18:59
 */
public class Solution4 {
    static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[] seeds = new char[]{'a','b','c','d','e','f'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] graph = new char[6][6];
        for (int i = 0; i < 6; i++) {
            String s = in.nextLine();
            graph[i] = s.toCharArray();
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (graph[i][j] == '*') {
                    res++;
                    dfs(i, j, graph);
                }
            }
        }
        System.out.println(res);
    }
    private static void dfs(int i, int j, char[][] graph) {
        if (i < 0 || i >= 6 || j < 0 || j >= 6 || graph[i][j] == '#') return;
        for (char seed : seeds) {
            graph[i][j] = seed;
            for (int[] direction : directions) {
                int newX = direction[0] + i;
                int newY = direction[1] + j;
                dfs(newX, newY, graph);
            }
        }
    }
}
