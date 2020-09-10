package baidu;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-03 18:56
 */
public class Solution1 {
    static long max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        boolean[] visted = new boolean[n];
        back(arr, new StringBuilder(), visted);
        System.out.println(max);
    }
    public static void back(int[] arr, StringBuilder curr, boolean[] visited) {
        if (curr.length() == arr.length) {
            long num = Long.parseLong(curr.toString());
            if (num % 90 == 0) {
                max = Math.max(max, num);
            }
            return;
        }
        // 做选择
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            curr.append(arr[i]);
            visited[i] = true;
            back(arr, curr, visited);
            curr.deleteCharAt(curr.length() - 1);
            visited[i] = false;
        }
    }
}
