package design;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-08-10 19:05
 *
 * 用两个栈实现一个队列。
 * 栈：先进后出
 * 队列：先进先出
 * 加入元素时，往第一个栈里面加入
 * 删除元素时，看第二个栈中有没有元素，若有，直接出栈，若没有，将第一个栈中的元素全部压入第二个栈中，再出栈
 */
public class T09_CQueue {
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
