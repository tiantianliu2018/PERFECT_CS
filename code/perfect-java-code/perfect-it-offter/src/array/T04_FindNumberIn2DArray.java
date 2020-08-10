package array;

/**
 * @author Kelly
 * @create 2020-08-10 09:53
 */
public class T04_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        // 从右上角开始查找
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
