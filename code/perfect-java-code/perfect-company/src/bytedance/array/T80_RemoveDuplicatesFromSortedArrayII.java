package bytedance.array;

/**
 * @author Kelly
 * @create 2020-07-13 13:55
 */
public class T80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 1, j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
