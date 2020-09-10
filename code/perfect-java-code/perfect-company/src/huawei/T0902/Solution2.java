package huawei.T0902;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-02 19:29
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        int M = Integer.parseInt(strs[0]);
        int N = Integer.parseInt(strs[1]);
        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            String s = in.nextLine();
            matrix[i] = s.toCharArray();
        }

    }
}
