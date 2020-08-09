package practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-25 19:50
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 双指针 + 结果先放尾部
 */
public class T977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int n = A.length;
        int i = 0, j = n - 1, k = n - 1;
        while (i <= j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k--] = A[i] * A[i];
                i++;
            } else {
                res[k--] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }

}
