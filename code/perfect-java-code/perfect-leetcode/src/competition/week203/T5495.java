package competition.week203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-23 10:33
 */
public class T5495 {
    public static void main(String[] args) {
        mostVisited(4, new int[]{1,3,1,2});
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        // 经过扇区的次数
        int[] counts = new int[n + 1];
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (start < end) {
                // 没有越过最大值
                for (int j = start; j < end; j++) {
                    counts[j]++;
                }
            } else {
                // 越过了最大值，分成两段
                for (int j = start; j <= n; j++) {
                    counts[j]++;
                }
                for (int j = 1; j < end; j++) {
                    counts[j]++;
                }
            }
            if (i == rounds.length - 2) {
                counts[end]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.print(counts[i] + " ");
        }
        // 统计频率最大的赛道
        List<Integer> res = new ArrayList<>();
        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                res.clear();
                res.add(i);
            } else if (counts[i] == max) {
                res.add(i);
            }
        }
        return res;

    }
}
