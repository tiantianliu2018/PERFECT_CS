package dailychallenge.array;

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。
 * 不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回.
 *
 * @author Kelly
 * @create 2021-07-04 10:11
 */
public class T645_SetMismatch {
    public static void main(String[] args) {
        System.out.println("findErrorNums(new int[]{}) = " + Arrays.toString(findErrorNums1(new int[]{1, 1})));
    }

    /**
     * 遍历两次
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] array = new int[n + 1];
        int[] res = new int[2];
        for (int idx : nums) {
            if (array[idx] != 0) {
                res[0] = idx;  // = array[idx]
            }
            array[idx] = idx;
        }
        for (int i = 1; i <= n; i++) {
            if (array[i] == 0) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    /**
     * 两次遍历另一种方法
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        int[] array = new int[n + 1];
        for (int num : nums) {
            array[num]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < n + 1; i++) {
            if (array[i] == 2) {
                res[0] = i;
            }
            if (array[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}
