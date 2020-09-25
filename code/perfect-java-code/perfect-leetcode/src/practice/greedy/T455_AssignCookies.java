package practice.greedy;

import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-09-24 10:25
 */
public class T455_AssignCookies {
    /**
     * 尽量用最小的饼干满足最小胃口的孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
