package meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-15 16:02
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> res = new ArrayList<>();
        int count = 0;
        for (int i = 10; i < n; i++) {
            // 10 的倍数不用看
            if (i % 10 == 0) continue;
            // 首位大于末位，不用看
            int reverse = getReverse(i);
            if (i * 4 == reverse) {
                count++;
                res.add(new int[]{i, reverse});
            }
        }
        System.out.println(count);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
    private static int getReverse(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
        StringBuilder s = new StringBuilder(num);
        s.reverse();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') s.replace(i, i + 1, "");
        }
        return Integer.parseInt(s.toString());
    }
}
