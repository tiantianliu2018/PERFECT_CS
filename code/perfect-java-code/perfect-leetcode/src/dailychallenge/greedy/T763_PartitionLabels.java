package dailychallenge.greedy;

import dailychallenge.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-10-22 21:13
 *
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class T763_PartitionLabels {
    /**
     * 用一个 26 的数组记录每个字母最后出现的位置，然后遍历字符串
     * 从第一个字符开始，找到最后出现的位置，遍历其中的字符，不断进行扩充
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] pos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, pos[c - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
