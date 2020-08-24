package tencent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-08-23 19:53
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        Stack<Character> stack = new Stack<>();
        int count = s.length() - k;
        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty() && count != 0 && stack.peek() > s.charAt(i)) {
                stack.pop();
                count--;
            }
            if (count == 0) {
                LinkedList<Character> list = new LinkedList<>();
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                Collections.reverse(list);
                for (Character c : list) {
                    System.out.print(c);
                }
                String tailStr = s.substring(i, s.length());
                System.out.println(tailStr);
                return;
            }
            stack.add(s.charAt(i));
        }
        LinkedList<Character> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        String sub = s.substring(0, k);
        System.out.println(sub);
    }
}