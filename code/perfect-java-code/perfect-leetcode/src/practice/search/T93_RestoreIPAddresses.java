package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-09 09:06
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class T93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        backTrack(s, res, new ArrayList<>(), 0);
        return res;
    }
    public void backTrack(String s, List<String> res, List<String> curr, int index) {
        if (curr.size() > 4) return;
        if (curr.size() == 4 && index == s.length()) {
            res.add(String.join(".", curr));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;  // 剩下的数字凑不成一个有效的 IP 地址
            String sub = s.substring(index, index + i);
            // 有效的 ip 地址格式：不能以 0 开头，范围在 0-255
            if (Integer.parseInt(sub) > 255 || (sub.startsWith("0") && sub.length() > 1)) continue;
            // 做选择
            curr.add(sub);
            backTrack(s, res, curr, index + i);
            // 撤销选择
            curr.remove(curr.size() - 1);
        }
    }
}
