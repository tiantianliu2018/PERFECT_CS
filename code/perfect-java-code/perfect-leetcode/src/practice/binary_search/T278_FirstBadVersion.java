package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 09:25
 */
public class T278_FirstBadVersion {
    // 二分查找，如果 mid 是正确版本，就在 【mid + 1, right】找，否在在 【left, mid】找
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 当前版本出错了，那么第一版错误肯定在 [left, mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean isBadVersion(int version){return true;}
}
