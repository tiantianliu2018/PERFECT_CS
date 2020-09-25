package practice.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-25 10:22
 *
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class T763_PartitionLabels {
    /**
     * 贪心的思想，从第一个字母开始，找到其在字符串中出现的最后位置，然后再看其中的字母。
     * 根据中间字母出现的位置，看是否需要扩充区间
     * 因为都是小写字母，可以开一个 26 的数组，记录每个字母最后出现的位置
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] lastPos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            lastPos[c - 'a'] = i;
        }
        int start = 0, end = 0;
        // 遍历字符串
        for (int i = 0; i < S.length(); i++) {
            // 扩充边界
            end = Math.max(end, lastPos[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels1(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] lastPos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastPos[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        while (start < S.length()) {
            int end = start;
            // 看 start - end 中间的字母是否对区间进行了扩充
            for (int i = start; i < S.length() && i <= end; i++) {
                int idx = lastPos[S.charAt(i) - 'a'];
                if (idx > end) {
                    end = idx;
                }
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}
