package vip;

/**
 * @author Kelly
 * @create 2020-07-02 21:35
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 注意：1 ≤ k ≤ n ≤ 10^9
 *
 * 样例：n: 13   k: 2  输出：10
 * [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * 字节 8 次
 */
public class T440_KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        k = k - 1;
        int prefix = 1;  // 当前前缀从 1 开始
        while (k > 0) {
            int count = getNode(n, prefix);
            // 第 k 个数不在以 cur 为根节点的树上
            if (count <= k) {
                prefix++;  // 移动到下一个子树
                k -= count;
            } else {   // 在当前前缀里面
                prefix *= 10;
                k -= 1;  // 下移一个节点去找
            }
        }
        return prefix;
    }

    /**
     * 返回以 prefix 开头的数字的个数
     */
    public int getNode(int n, long prefix) {
        long nextPrefix = prefix + 1;
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }
}
