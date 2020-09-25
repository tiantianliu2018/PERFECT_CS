package practice.array.sort;

/**
 * @author Kelly
 * @create 2020-09-24 10:08
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 0000 1111 2222
 */
public class T75_SortColors {
    /**
     * 有点类似于三路快排的思想
     * 三指针，一个指针 p0 指向 0 的右侧位置， 初始化为 0，一个指针 p2 指向 2 的左侧位置，初始化为 n-1
     * 一个指针从前往后扫描，若遇到 0，和 p0 交换，p0++, cur++，遇到 2 和 p2 交换，p2--, 遇到 1 不交换。
     * 遇到 2 交换的时候不进行 cur++, 是因为和 p2 位置新交换来的数据还没有扫描过。
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p0 = 0, p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 和 p0 交换
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
