package competition.week203;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-08-23 11:06
 */
public class T5497 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,4,2};
        int latestStep = findLatestStep(arr, 1);
        System.out.println(latestStep);
    }
    public static int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[] num = new int[n + 1];  // 0 位置空着不用
        int res = -1;
        for (int i = 1; i <= n; i++) {
            int pos = arr[i - 1];
            num[pos] = 1;
            // 看当前数字有几个连续的 1
            int count = 0;
            for (int j = 1; j < num.length; j++) {
                if (num[j] == 0) {
                    if (count == m) {
                        res = i;
                        break;
                    }
                    count = 0;
                } else if (num[j] == 1) {
                    count++;
                }
            }
            if (count == m) res = i;

        }
        return res;
    }

}
