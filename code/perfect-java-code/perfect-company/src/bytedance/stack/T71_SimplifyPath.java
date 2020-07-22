package bytedance.stack;

import java.util.Stack;

/**
 * @author Kelly
 * @create 2020-07-19 18:14
 */
public class T71_SimplifyPath {
    public static void main(String[] args) {
        String res = simplifyPath("/home//foo/");
        System.out.println(res);
    }

    /**
     * 根据 "/" 截取路径，遇到 “.” 和空不管，遇到 “..” 出栈，遇到字母入栈，最后出栈构造路径
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        System.out.println("路径的长度: " + strings.length);
        for (String s : strings) {
            System.out.println(s);
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("栈顶元素：" + stack.peek());
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }
}
