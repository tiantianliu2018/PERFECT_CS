package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-22 10:56
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class T69_SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * mid == x) return mid;
            else if ((long) mid * mid < x) {
                left = mid;  // mid 有可能是解
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
