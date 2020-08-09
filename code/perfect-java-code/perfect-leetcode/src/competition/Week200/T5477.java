package competition.Week200;

/**
 * @author Kelly
 * @create 2020-08-02 11:06
 */
public class T5477 {
    public int minSwaps(int[][] grid) {
        // 判断 grid 的特殊情况
        int n = grid.length;
        boolean upAllZero = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == 1) upAllZero = false;
            }
        }
        if (upAllZero) return 0;
        // 判断每一列是否相同
        boolean same = true;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                if (grid[i] != grid[i - 1]) same = false;
            }
        }
        if (same) return -1;
        // 最小交换次数
        return n;
    }
}
