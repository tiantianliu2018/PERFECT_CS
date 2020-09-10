package bit;

/**
 * @author Kelly
 * @create 2020-08-27 10:25
 *
 * 输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数。
 *
 */
public class T43_CountDigitOne {
    public int countDigitOne(int n) {
        // 初始化
        int high = n / 10, low = 0, curr = n % 10;
        int base = 1;  // 每一位的基数 各位 1，十位 10
        int res = 0;
        while (base < n) {
            if (curr == 0) {
                // 当前位是 0，1 的个数仅由高位决定
                res += high * base;
            } else if (curr == 1) {
                // 当前位是 1， 1 的个数由高位和低位共同决定
                res += high * base + low + 1;
            } else {
                res += (high + 1) * base;
            }
            // 更新 high low curr
            low = curr * base + low;
            curr = high % 10;
            high /= 10;
            base *= 10;
        }
        return res;
    }

}
