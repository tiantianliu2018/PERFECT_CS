package math;

/**
 * 实现函数 double Power(double base, int exponent)，求 base的 exponent 次方。
 */
public class T16_MyPow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long m = n;
        // 如果要求的幂是负数，变为（1/x）^ -n
        if (m < 0) {
            m = -m;
            x = 1 / x;
        }
        return fastPow(x, m);
    }
    // 快速幂乘
    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double res = fastPow(x, n >> 1);
        // 偶数次幂
        if ((n & 1) == 0) return res * res;
        // 奇数次幂
        return res * res * x;
    }
}
