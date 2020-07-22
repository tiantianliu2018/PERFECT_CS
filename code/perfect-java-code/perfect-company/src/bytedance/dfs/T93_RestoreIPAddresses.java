package bytedance.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-07-21 22:53
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class T93_RestoreIPAddresses {
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backtrack(res, s, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(List<String> res, String s, int index, LinkedList<String> list) {
        if (list.size() > 4) return;
        if (list.size() == 4 && index == s.length()) {
            res.add(String.join(".", list));
            return;
        }
        // 每个 ip 地址段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            String str = s.substring(index, index + i);
            // 有效的 ip 地址段：不能以 “0” 开头，不能大于 255
            if ((str.startsWith("0") && str.length() > 1) || (Integer.parseInt(str) > 255)) continue;
            list.add(str);
            backtrack(res, s, index + i, list);
            list.removeLast();
        }
    }

    /**
     * 解法 1
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backTracking(res, s, new StringBuilder(), 0, 0);
        return res;
    }
    private void backTracking(List<String> res, String s, StringBuilder curr, int count, int index) {
        if (count > 4) return;
        if (index == s.length() && count == 4) {
            res.add(curr.substring(1));
            return;
        }
        for (int i = index; i < s.length() && i - index < 3; i++) {
            String str = s.substring(index, i + 1);
            // 进行剪枝
            if (str.startsWith("0") && str.length() > 1) return;
            // 符合条件的数字
            if (Integer.parseInt(str) <= 255) {
                curr.append(".").append(str);
                backTracking(res, s, curr, count + 1, i + 1);
                curr.delete(curr.lastIndexOf("."), curr.length());
            }
        }
    }
}
