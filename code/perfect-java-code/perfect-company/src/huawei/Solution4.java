package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-12 18:49
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(",");
        String s = strings[0];
        int num = Integer.parseInt(strings[1]);
        String res = getNewString(s, num);
        System.out.println(res);
    }
    public static String getNewString(String s, int num) {
        int cols = num;
        List<int[]> list = new ArrayList<>();
//        list.add(new int[5]);
        int left = 0, right = num - 1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                if (left == right) {
                    list.get(list.size() - 1)[left] = s.charAt(i);
                    flag = true;
                    continue;
                }
                if (left > num) left = 0;
                list.add(new int[5]);
                list.get(list.size() - 1)[left] = s.charAt(i);
                left++;
                flag = false;
            } else {
                if (right < 0) {
                    right = num - 1;
                }
                list.get(list.size() - 1)[right] = s.charAt(i);
                right--;
                flag = true;
            }
        }
        StringBuilder res = new StringBuilder();
        char[][] chars = new char[list.size()][5];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < list.size(); i++) {
                res.append(list.get(i)[j]);
            }
        }
        return res.toString();
    }
}
