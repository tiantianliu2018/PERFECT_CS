package meituan;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-08-15 17:31
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int a = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = in.nextLine().split(" ");
            list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        Collections.sort(list, (a1, b1) -> a1[0] - b1[0]);
        int p1 = 0;
        for (int i = 0; i < a; i++) {
            p1 += list.get(i)[0];
            p1 += list.get(i)[1];
        }
        Collections.sort(list, (a1, b1) -> a1[1] - b1[1]);
        int p2 = 0;
        for (int i = 0; i < b; i++) {
            p2 += list.get(i)[0];
            p2 += list.get(i)[1];
        }
        System.out.println(Math.max(p1,p2));
    }
}
