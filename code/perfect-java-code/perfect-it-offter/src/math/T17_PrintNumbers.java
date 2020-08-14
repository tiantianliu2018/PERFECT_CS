package math;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 */
public class T17_PrintNumbers {
    public int[] printNumbers(int n) {
        if (n < 1) return new int[0];
        int num = fastPow(10, n) - 1;
        int[] res = new int[num];
        for (int i = 1; i <= num; i++) {
            res[i - 1] = i;
        }
        return res;
    }
    private int fastPow(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) res *= x;
            n /= 2;
            x *= x;
        }
        return res;
    }
}
