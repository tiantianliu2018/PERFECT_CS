package array;

/**
 * @author Kelly
 * @create 2020-08-21 21:30
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class T39_MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res != nums[i]) {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return res;
    }
}
