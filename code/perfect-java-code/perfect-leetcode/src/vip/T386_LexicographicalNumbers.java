package vip;

import java.util.*;

/**
 * @author Kelly
 * @create 2020-07-05 10:54
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度
 */
public class T386_LexicographicalNumbers {
    /**
     * 10 叉树
     * 暴力解答，把数字转为字符串放到堆中，然后通过其进行比较
     * 时间复杂度: 遍历数字 O(n)，内部进行堆排序，O(logn)，总的时间复杂度是 O(n * logn)
     * 空间复杂度：维护了一个队列，为 O(logn)
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            heap.offer(String.valueOf(i));
        }
        while (!heap.isEmpty()) {
            res.add(Integer.valueOf(heap.poll()));
        }
        return res;
    }

    /**
     * dfs
     */
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dfs(res, n, i);
        }
        return res;
    }

    private void dfs(List<Integer> list, int n, int curr) {
        if (curr > n) return;
        list.add(curr);
        for (int i = 0; i < 10; i++) {
            dfs(list, n, curr * 10 + i);
        }
    }


}
