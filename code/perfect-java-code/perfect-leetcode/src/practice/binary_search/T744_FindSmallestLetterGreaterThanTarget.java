package practice.binary_search;

/**
 * @author Kelly
 * @create 2020-09-23 09:03
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
 * 另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 */
public class T744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        // 提前判断边界
        if (target < letters[0] || target >= letters[n-1]) return letters[0];
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                // mid 一定不是解
                left = mid + 1;
            } else if (letters[mid] > target){
                // 严格大于有可能是解
                right = mid;
            }
        }
        return letters[left];
    }
}
