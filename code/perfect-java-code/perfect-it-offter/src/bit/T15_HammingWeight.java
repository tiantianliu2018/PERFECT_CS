package bit;

/**
 * @author Kelly
 * @create 2020-08-11 19:58
 */
public class T15_HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            // 移除等于 1 的最右比特位
            n &= (n - 1);
        }
        return res;
    }
}
