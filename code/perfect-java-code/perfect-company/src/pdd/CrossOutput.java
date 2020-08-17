package pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2020-08-15 08:42
 *
 * 任选一种编程语言，写代码，实现功能。
 * 有个int数组，int[]。
 * n个元素为一组，正序输出。
 * m个元素为一组，逆序输出。
 * 然后重复上面两步。
 * eg: [1,2,3,4,5,6,7,8,9,10]
 * n = 2, m = 3
 * [1,2,5,4,3,6,7,10,9,8]
 */
public class CrossOutput {
    public static void main(String[] args) {
        List<Integer> list = crossOutput(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, 3);
        list.forEach(System.out::println);
    }
    public static List<Integer> crossOutput(int[] arr, int n, int m) {
        List<Integer> res = new ArrayList<>();
        List<Integer> subArr = new ArrayList<>(n);
        List<Integer> reverseSubArr = new ArrayList<>(m);
        int i = 0;
        while (i < arr.length) {
            while (subArr.size() < n) {
                subArr.add(arr[i]);
                i++;
            }
            while (reverseSubArr.size() < m) {
                reverseSubArr.add(0, arr[i]);
                i++;
            }
            res.addAll(subArr);
            res.addAll(reverseSubArr);
            subArr.clear();
            reverseSubArr.clear();
        }
        return res;
    }
}
