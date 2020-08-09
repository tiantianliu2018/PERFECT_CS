package huawei;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-05 19:17
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        // 生成数组
        String name = s[0];
        int target = 0;
        for (char c : name.toCharArray()) {
            target += c - 'a' + 1;
        }
        String res = "";
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < s.length; i++) {
            int lucky = 0;
            for (char c : s[i].toCharArray()) {
                lucky += c - 'a' + 1;
            }
            if (Math.abs(target - lucky) <= minGap) {
                minGap = Math.abs(target - lucky);
                res = s[i];
            }
        }
        System.out.println(res);
    }
}
