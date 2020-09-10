package math;

/**
 * @author Kelly
 * @create 2020-08-27 11:07
 */
public class T44_FindNthDigit {
    public int findNthDigit(int n) {
        int base = 1, start = 1, num = 9;
        while (n > (long) base * start * num) {
            n -= base * start * num;
            base++;
            start *= 10;
        }
        int count = start + (n - 1) / base;
        return 0;
    }
}
