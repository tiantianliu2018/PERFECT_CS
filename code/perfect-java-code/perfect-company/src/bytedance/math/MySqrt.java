package bytedance.math;

/**
 * @author Kelly
 * @create 2020-07-12 17:25
 */
public class MySqrt {
    /**
     * 牛顿迭代法
     */
    public static double getMySqrt(double target, double precision) {
        double x = target / 2;
        while (Math.abs(target - x * x) > precision) {
            x = (x + target / x) / 2;
        }
        return x;
    }

    /**
     * 二分查找, 不太行啊
     */
    public static double getMySqrt1(double target, double precision) {
        double left = 0, right = target;
        double mid = (left + right) / 2;
        while (true) {
            if (Math.abs(target - mid * mid) < precision) return mid;
            if (mid * mid > target) {
                right = mid;
            } else if (mid * mid < target) {
                left = mid;
            }
            mid = (left + right) / 2;
        }
    }

    public static void main(String[] args) {
        double res = getMySqrt(4.1, 0.0001);
        double res1 = getMySqrt(501.1, 0.0001);
        double res2 = getMySqrt(0.045, 0.0001);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
}
