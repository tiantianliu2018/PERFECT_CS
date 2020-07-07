package vip;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Kelly
 * @create 2020-07-02 22:15
 */
public class T726_NumberOfAtoms {
    int index = 0;
    public String countOfAtoms(String formula) {
        StringBuilder res = new StringBuilder();
        Map<String, Integer> count = parse(formula);
        // 组合结果输出
        for (String name : count.keySet()) {
            res.append(name);
            int num = count.get(name);
            if (num > 1) res.append("" + num);
        }
        return res.toString();
    }

    // 解析字符串，返回一个 hashMap
    private Map<String, Integer> parse(String formula) {
        int n = formula.length();
        Map<String, Integer> count = new HashMap<>();
        // 左括号或者字母数字
        while (index < n && formula.charAt(index) != ')') {
            // 解析 （） 内的内容
            if (formula.charAt(index) == '(') {
                index++;
                for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = index++;
                while (index < n && Character.isLowerCase(formula.charAt(index))) index++;  // 小写字母继续看
                String name = formula.substring(iStart, index);
                iStart = index;
                while (index < n && Character.isDigit(formula.charAt(index))) index++;
                int multiplicity = iStart < index ? Integer.parseInt(formula.substring(iStart, index)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++index;
        while (index < n && Character.isDigit(formula.charAt(index))) index++;
        if (iStart < index) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, index));
            for (String key : count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }

    /**
     * 用栈来模拟递归
     */
    public String countOfAtoms1(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int i = 0;
        while (i < n) {
            // 遇到左括号，将一个 TreeMap 入栈
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {  // 遇到右括号，出栈，并计算当前括号内的原子
                Map<String, Integer> map = stack.pop();
                int iStart = ++i;
                int multiplicity = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
                for (String name : map.keySet()) {
                    int val = map.get(name);
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + val * multiplicity);
                }
            } else {  // 字母
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(i)) i++;  // 原子的个数
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        // 将 map 组合成字符串输出
        StringBuilder res = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            res.append(name);
            int val = stack.peek().get(name);
            if (val > 1) res.append("" + val);
        }
        return new String(res);
    }
}
