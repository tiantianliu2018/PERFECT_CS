package array;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class T29_SpiralOrderPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[] res = spiralOrder(matrix);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;
        // 模拟打印
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        int [] res = new int[n * m];
        int idx = 0;
        while (top <= bottom && left <= right) {
            // 从左到右打印
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            if (++top > bottom) break;
            // 从上到下打印
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            if (--right < left) break;
            // 从右到左打印
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            if (--bottom < top) break;
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}
