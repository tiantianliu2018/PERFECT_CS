package wangyi;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-09-05 14:52
 */
public class solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            if (map.containsKey(s[1])) {
                map.get(s[1]).add(s[0]);
            } else {
                map.put(s[1], new LinkedList<>());
                map.get(s[1]).add(s[0]);
            }
        }
        int res = 0;
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list != null && list.size() >= 2) {
                res++;
            }
        }
        System.out.println(res);
    }
}
