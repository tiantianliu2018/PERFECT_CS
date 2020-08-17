package design;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
 * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class T30_MinStack {
    /**
     * push 如果当前要加入的数小于最小值栈的栈顶，加入最小值栈，否则继续往最小值栈加入其栈顶
     */
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            // 要加入的值大于 minStack 栈顶，栈顶继续加入，表示当前位置的最小值
            if (!minStack.isEmpty() && x > minStack.peek()) {
                minStack.push(minStack.peek());
            } else minStack.push(x);
        }

        public void pop() {
            if (!stack.isEmpty() && !minStack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int min() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }
}
