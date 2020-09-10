package tencent.mianjing;

/**
 * @author Kelly
 * @create 2020-08-31 09:20
 *  计算 2 的 1000 次方
 */
public class BigPowOfTwo {
    public static void main(String[] args) {
        int[] arr = new int[1024];
        arr[0] = 1;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1024; j++) {
                arr[j] *= 2;
            }
            for (int j = 0; j < 1024; j++) {
                if (arr[j] > 9) {
                    arr[j + 1] += 1;
                    arr[j] %= 10;
                }
            }
        }
        // 倒序遍历数组
        int idx = 0;
        for (int i = 1023; i >= 0; i--) {
            if (arr[i] == 0) idx++;
            else break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1023 - idx; i >= 0; i--) {
            res.append(arr[i]);
        }
        System.out.println(res);
    }
}
