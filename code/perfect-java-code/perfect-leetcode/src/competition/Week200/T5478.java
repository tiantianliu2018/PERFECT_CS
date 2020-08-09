package competition.Week200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kelly
 * @create 2020-08-02 11:22
 */
public class T5478 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4,5,8,10};
        int[] nums2 = new int[]{4,6,8,9};
        int res = maxSum(nums1, nums2);
        System.out.println(res);
    }
    public static int maxSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], i);
        }
        int maxSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums1[j];
            }
            if (map2.containsKey(nums1[i])) {
                int index = map2.get(nums1[i]);
                int sum1 = sum;
                int sum2 = sum;
                for (int j = i + 1; j < nums1.length; j++) {
                    sum1 += nums1[j];
                }
                for (int j = index + 1; j < nums2.length; j++) {
                    sum2 += nums2[j];
                }
                int currSum = Math.max(sum1, sum2);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums2[j];
            }
            if (map1.containsKey(nums2[i])) {
                int index = map1.get(nums2[i]);
                int sum1 = sum;
                int sum2 = sum;
                for (int j = index + 1; j < nums1.length; j++) {
                    sum1 += nums1[j];
                }
                for (int j = i + 1; j < nums2.length; j++) {
                    sum2 += nums2[j];
                }
                int currSum = Math.max(sum1, sum2);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}
