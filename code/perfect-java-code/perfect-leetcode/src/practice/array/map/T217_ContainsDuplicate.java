package practice.array.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 10:14
 */
public class T217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
