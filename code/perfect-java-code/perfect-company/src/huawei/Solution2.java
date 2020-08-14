package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-12 18:49
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < s.length; i++) {
            int num = Integer.parseInt(s[i]);
            if (num != 5 && num != 10 && num != 20) {
                flag = false;
            } else if (num == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else {
                if (map.isEmpty() || map.size() == 0) {
                    flag = false;
                } else {
                    int check = num - 5;
                    if (check == 5 && map.containsKey(5) && map.get(5) > 0) {
                        map.put(5, map.get(5) - 1);
                        map.put(10, map.getOrDefault(10, 0) + 1);
                    } else if (check == 5 && map.get(5) <= 0) {
                        flag = false;
                    } else if (check == 15 && map.get(5) <= 0) {
                        flag = false;
                    } else if (check == 15 && map.containsKey(10) && map.get(10) > 0 && map.get(5) > 0) {
                        map.put(10, map.get(10) - 1);
                        map.put(5, map.get(5) - 1);
                    } else if (check == 15 && map.get(5) >= 3){
                        map.put(5, map.get(5) - 3);
                    } else {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                System.out.println("false," + (i + 1));
                break;
            }
        }
        if (flag) System.out.println("true," + s.length);
    }
}
