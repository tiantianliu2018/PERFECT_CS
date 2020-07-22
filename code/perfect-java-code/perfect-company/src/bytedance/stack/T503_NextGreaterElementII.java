package bytedance.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-07-19 17:48
 */
public class T503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) return res;
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            int index = i % nums.length;
            // 只要栈顶大于当前元素就入栈，否则当前元素大于栈顶，出栈就是结果
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}
