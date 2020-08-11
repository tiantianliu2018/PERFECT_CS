package dp;

/**
 * @author Kelly
 * @create 2020-08-10 19:25
 */
public class T10_1Fib {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int first = 0, second = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (first + second) % 1000000007;
            first = second;
            second = res;
        }
        return res % 1000000007;
    }
}
