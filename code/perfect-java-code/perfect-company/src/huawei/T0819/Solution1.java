package huawei.T0819;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-19 19:15
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
        if (m < 10 || n < 10) {
            System.out.println();
            return;
        }
        // 模拟打印
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int idx = 1;
        List<int[]> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // 从左到右打印
            for (int i = left; i <= right; i++) {
                if (idx % 10 == 7 && (idx/10%10) % 2 == 1) {
                    res.add(new int[]{top, i});
                }
                idx++;
            }
            if (++top > bottom) break;
            // 从上到下打印
            for (int i = top; i <= bottom; i++) {
                if (idx % 10 == 7 && (idx/10%10) % 2 == 1) {
                    res.add(new int[]{i, right});
                }
                idx++;
            }
            if (--right < left) break;
            // 从右到左打印
            for (int i = right; i >= left; i--) {
                if (idx % 10 == 7 && (idx/10%10) % 2 == 1) {
                    res.add(new int[]{bottom, i});
                }
                idx++;
            }
            if (--bottom < top) break;
            // 从下到上
            for (int i = bottom; i >= top; i--) {
                if (idx % 10 == 7 && (idx/10%10) % 2 == 1) {
                    res.add(new int[]{i, left});
                }
                idx++;
            }
            if (++left > right) break;
        }
        System.out.print("[");
        for (int j = 0; j < res.size() - 1; j++) {
            System.out.print("[" + res.get(j)[0] + "," + res.get(j)[1] + "]");
            System.out.print(",");
        }
        System.out.print("[" + res.get(res.size()-1)[0] + "," + res.get(res.size()-1)[1] + "]");
        System.out.println("]");
    }
}
