package practice.greedy;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-09-24 11:01
 */
public class T406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
        // 根据身高从大到小排序，身高相同的，根据位置排序
        Arrays.sort(people, (a, b) -> (a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[people.length][2]);
    }
}
