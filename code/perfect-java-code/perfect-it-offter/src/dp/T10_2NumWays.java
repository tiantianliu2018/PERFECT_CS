package dp;

/**
 * @author Kelly
 * @create 2020-08-10 19:30
 */
public class T10_2NumWays {
    public int numWays(int n) {
        if (n < 2) return 1;
        // 0 级台阶一种，不上；1 级台阶，1 种
        int first = 1, second = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (first + second) % 1000000007;
            first = second;
            second = res;
        }
        return res % 1000000007;
    }
}
