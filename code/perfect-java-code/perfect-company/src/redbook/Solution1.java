package redbook;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-09-06 19:36
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+")) {
                int l = stack.pop();
                int ll = stack.pop();
                stack.push(ll);
                stack.push(l);
                stack.push(l + ll);
                res += stack.peek();
            } else if (s[i].equals("T")) {
                stack.push(stack.peek() * 3);
                res += stack.peek();
            } else if (s[i].equals("-")) {
                int l = stack.pop();
                int ll = stack.pop();
                stack.push(ll);
                stack.push(l);
                stack.push(Math.abs(l - ll));
                res += stack.peek();
            } else if (s[i].equals("C")) {
                int l = stack.pop();
                res -= l;
            } else {
                stack.push(Integer.parseInt(s[i]));
                res += Integer.parseInt(s[i]);
            }
        }
        System.out.println(res);
    }
}
