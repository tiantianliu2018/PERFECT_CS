package competition.Week200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-02 10:45
 */
public class T5476 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,11,22,33,44,55,66,77,88,99};
        int winner = getWinner(arr, 1000000000);
        System.out.println(winner);
    }
    public static int getWinner(int[] arr, int k) {
        List<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            max = Math.max(arr[i], max);
        }
        if (k > arr.length) return max;
        int maxVal = 0;
        int t = 0;
        while (true) {
            if (list.get(0) > list.get(1)) {
                if (list.get(0) == maxVal) {
                    t++;
                    if (t == k) break;
                } else {
                    maxVal = list.get(0);
                    t = 1;
                }
                // 移动链表位置
                Integer remove = list.remove(1);
                list.add(remove);
            } else {
                if (list.get(1) == maxVal) {
                    t++;
                    if (t == k) break;
                } else {
                    maxVal = list.get(1);
                    t = 1;
                }
                Integer remove = list.remove(0);
                list.add(remove);
            }
        }
        return maxVal;
    }

}
