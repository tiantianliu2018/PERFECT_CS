package dp;

/**
 * @author Kelly
 * @create 2020-08-11 19:45
 */
public class T14_2CuttingRope {
    /**
     * 由于范围变大，所以用 dp 就比较难，要用数学方法
     */
    public int cuttingRope(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
