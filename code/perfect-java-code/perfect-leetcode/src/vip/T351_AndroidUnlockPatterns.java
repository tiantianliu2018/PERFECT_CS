package vip;

/**
 * @author Kelly
 * @create 2020-07-02 23:26
 *
 * 回溯法
 *
 */
public class T351_AndroidUnlockPatterns {
    private boolean[] used = new boolean[9];
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += calPattern(-1, i);
        }
        return res;
    }

    /**
     * 计算经过 len 个点，可以解锁的手势数
     * @param last  上一个访问的数字
     * @param len 要经过 len 个点
     * @return 可以解锁的手势数
     */
    private int calPattern(int last, int len) {
        if (len == 0) return 1;
        int sum = 0;
        // 遍历访问每一个数字
        for (int i = 0; i < 9; i++) {
            // 判断访问数字 i 时，是否有效
            if (isValid(i, last)) {
                used[i] = true;
                // 访问下一个点
                sum += calPattern(i, len - 1);
                used[i] = false;
            }
        }
        return sum;
    }

    /**
     * 判断这个位置有没有效
     */
    private boolean isValid(int index, int last) {
        if (used[index]) return false;  // 该位置已经用过，直接返回 false
        if (last == -1) return true;    // 每个模式里面的第一个数字
        if ((index + last) % 2 == 1) return true;  // 上一次和本次数字和为奇数（相邻行和列+马的走法），满足条件
        int mid = (index + last) / 2; // 如果中间隔了一个数，看中间那个数是不是 5（数字从 0 开始，下标 4 代表 5）
        if (mid == 4) return used[mid];    // 中间数字是 5，看有没有用过，用过就是 true
        // 对角线
        if ((index % 3 != last % 3) && (index / 3 != last /3)) return true;
        return used[mid];  // 其他非邻接情况
    }

    /**
     * 并查集
     */
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            parent[pRoot] = parent[qRoot];
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    UnionFind unionFind = new UnionFind(10);
    int res = 0;

    public int numberOfPatterns1(int m, int n) {
        initializeUF();
        for (int i = 1; i < 10; i++) {
            dfs(i, 1, m, n);
        }
        return res;
    }

    private void dfs(int p, int currLen, int m, int n) {
        if (currLen >= m && currLen <= n) res++;
        else if (currLen > n) return;
        used[p] = true;
        for (int i = 1; i <= 9; i++) {
            boolean isConnected = unionFind.connected(p, i);
            // i 未被访问, p i 位于同一分支 且第三者（中间节点）被访问过 继续搜索
            // i 未被访问, p i 位于不同分支 继续搜索
            if (!used[i] && (!isConnected || used[(p + i) >>> 1])) {
                dfs(i,currLen + 1, m, n);
            }
        }
        used[p] = false;
    }

    private void initializeUF() {
        unionFind.union(1, 3);
        unionFind.union(1, 7);
        unionFind.union(1, 9);
        unionFind.union(4,6);
        unionFind.union(2, 8);
    }
}
