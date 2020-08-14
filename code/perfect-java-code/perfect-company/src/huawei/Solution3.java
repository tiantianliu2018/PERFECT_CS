package huawei;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-12 18:49
 */
public class Solution3 {
    static int M, N;
    static int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());
        String[] size = in.nextLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] strings = in.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(strings[j]);
            }
        }
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        if (dfs(matrix, 0, 0, s, visited)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean dfs(int[][] matrix, int i, int j, int s, boolean[][] visited) {
        if (i == M - 1 || j == N - 1 || matrix[i][j] == 0) return false;
        if (i == M || j == N || matrix[i][j] == 1) return true;
        for (int[] direction : directions) {
            int newX = i + direction[0] * s;
            int newY = j + direction[1] * s;
            if (newX < 0 || newX >= M || newY < 0 || newY >= N || matrix[newX][newY] == 0 || visited[newX][newY]) continue;
            visited[newX][newY] = true;
            if (dfs(matrix, newX, newY, s, visited)) return true;
            visited[newX][newY] = false;
        }
        return false;
    }
}
