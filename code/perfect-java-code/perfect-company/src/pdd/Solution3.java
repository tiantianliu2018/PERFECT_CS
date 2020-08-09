package pdd;

import com.sun.javafx.tools.packager.MakeAllParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 18:59
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]);
        // 餐食
        int[][] lunch = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] temp = in.nextLine().split(" ");
            lunch[i][0] = Integer.parseInt(temp[0]);
            lunch[i][1] = Integer.parseInt(temp[1]);
        }
        int[][] dinner = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] temp = in.nextLine().split(" ");
            dinner[i][0] = Integer.parseInt(temp[0]);
            dinner[i][1] = Integer.parseInt(temp[1]);
        }
        if (t == 0) {
            System.out.println(0);
            return;
        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            if (lunch[i][1] >= t) {
//                res = Math.min(res, lunch[i][0]);
//            } else {
//                for (int j = 0; j < m; j++) {
//                    if (dinner[j][1] >= t) {
//                        res = Math.min(res, dinner[j][0]);
//                    } else if (lunch[i][1] + dinner[j][1] >= t) {
//                        res = Math.min(res, lunch[i][0] + dinner[j][0]);
//                    }
//                }
//            }
//        }
//        if (res == Integer.MAX_VALUE) System.out.println(-1);
//        else System.out.println(res);
        Map<Integer, Integer> dinnerMap = new HashMap<>();
        for (int[] d : dinner) {
            dinnerMap.put(d[1], d[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int[] l : lunch) {

        }
    }
}
