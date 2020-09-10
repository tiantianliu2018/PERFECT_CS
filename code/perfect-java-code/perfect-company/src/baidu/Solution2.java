package baidu;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-03 18:56
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        System.out.println(T);
        for (int i = 0; i < T; i++) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int count = 0;
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(in.nextLine());
                List<List<int[]>> features = new ArrayList<>();
                for (int l = 0; l < k; l++) {
                    s = in.nextLine().split(" ");
                    features.get(l).add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
                }
                for (int l = 0; l < k / 2; l++) {
                    List<int[]> list = merger(features.get(l), features.get(k - l));
                    for (int[] item : list) {
                        count += item[1] - item[0] + 1;
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static List<int[]> merger(List<int[]> A, List<int[]> B) {
        int m = A.size();
        int n = B.size();
        int i = 0, j = 0;
        int left = 0, right = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            left = Math.max(A.get(i)[0], B.get(j)[0]);
            if (A.get(i)[1] < B.get(j)[1]) {
                right = A.get(i)[1];
                i++;
            } else {
                right = B.get(j)[1];
                j++;
            }
            if (left <= right) {
                res.add(new int[]{left, right});
            }
        }
        return res;
    }
}
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = Integer.parseInt(in.nextLine());
//        System.out.println(T);
//        for (int i = 0; i < T; i++) {
//            String[] s = in.nextLine().split(" ");
//            int n = Integer.parseInt(s[0]);
//            int m = Integer.parseInt(s[1]);
//            int[] cows = new int[n];
//            // 特性
//            for (int j = 0; j < m; j++) {
//                int k = Integer.parseInt(in.nextLine());
//                // 特性区间
//                for (int l = 0; l < k; l++) {
//                    s = in.nextLine().split(" ");
//                    int start = Integer.parseInt(s[0]), end = Integer.parseInt(s[1]);
//                    for (int t = start; t <= end ; t++) {
//                        cows[t] += 1;
//                    }
//                }
//            }
//            StringBuilder res = new StringBuilder();
//            int c = 0;
//            for (int j = 0; j < n; j++) {
//                if (cows[j] == m) {
//                    res.append(j);
//                    res.append(" ");
//                    c++;
//                }
//            }
//            System.out.println(c);
//            System.out.println(res.toString().trim());
//        }
//
//    }