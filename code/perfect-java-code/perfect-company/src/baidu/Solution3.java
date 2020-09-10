package baidu;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-03 18:56
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int res = upStairs(n, m, -1, -1);
        System.out.println(res);

    }
    public static int upStairs(int n, int m, int first, int second) {
        int res = 0;
        if (n == 0) return 1;
        if (n >= m) {
            for (int i = 1; i <= m; i++) {
                if (i == first || i == second) continue;
                else {
                    first = second;
                    second = i;
                    res += upStairs(n - i, m, first, second) % 1000000007;
                }
            }
        } else {
            first = second;
            second = n;
            res = upStairs(n, n, first, second) % 1000000007;
        }
        return res;
    }
}
