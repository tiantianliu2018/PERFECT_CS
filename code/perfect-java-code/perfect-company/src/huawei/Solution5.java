package huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-12 19:59
 */
public class Solution5 {
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
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean flag = false;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == M - 1 || poll[1] == N - 1) {
                flag = true;
                break;
            }
            for (int[] direction : directions) {
                int newX = poll[0] + direction[0] * s;
                int newY = poll[1] + direction[1] * s;
                if (newX < 0 || newX >= M || newY < 0 || newY >= N || matrix[newX][newY] == 0) continue;
                queue.add(new int[]{newX, newY});
            }
        }
        if (false) System.out.println(1);
        else System.out.println(0);
    }
}
