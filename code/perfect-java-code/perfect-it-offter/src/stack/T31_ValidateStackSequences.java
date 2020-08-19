package stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 */
public class T31_ValidateStackSequences {
    /**
     * 根据第一个 pushed 序列进行压栈，直到遇到栈顶为 popped 的位置相同的数，出栈
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
}
