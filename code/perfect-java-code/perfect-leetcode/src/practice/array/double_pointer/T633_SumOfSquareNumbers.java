package practice.array.double_pointer;

/**
 * @author Kelly
 * @create 2020-09-12 16:34
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b, 使得 a^2 + b^2 = c
 */
public class T633_SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            if (i * i + j * j == c) return true;
            else if (i * i + j * j < c) i++;
            else j--;
        }
        return false;
    }
}
