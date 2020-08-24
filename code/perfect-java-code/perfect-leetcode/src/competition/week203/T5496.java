package competition.week203;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Kelly
 * @create 2020-08-23 10:56
 */
public class T5496 {
    // 贪心，对数组进行排序，每次选择最大的两个和最小的那个数
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int maxSum = 0;
        int left = 0, right = piles.length - 2;
        while (left < right) {
            maxSum += piles[right];
            left++;
            right -= 2;
        }
        return maxSum;
    }

}
