package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class T38_Permutation {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        List<String> resList = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        backTracking(resList, chars, new StringBuilder(), visited);
        String[] res = new String[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void backTracking(List<String> res, char[] chars, StringBuilder curr, boolean[] visited) {
        if (curr.length() == chars.length) {
            res.add(curr.toString());
            return;
        }
        // 选择列表
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            // 做出选择
            curr.append(chars[i]);
            visited[i] = true;
            backTracking(res, chars, curr, visited);
            // 撤销选择
            curr.deleteCharAt(curr.length() - 1);
            visited[i] = false;
        }
    }

}
