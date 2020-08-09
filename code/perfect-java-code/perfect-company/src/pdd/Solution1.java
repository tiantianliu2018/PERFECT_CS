package pdd;

import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-08-02 18:58
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        int K = Integer.parseInt(str1[0]);
        int N = Integer.parseInt(str1[1]);
        int back = 0;
        for (int i = 0; i < N; i++) {
            int curr = in.nextInt();
            if (curr == K) {
                System.out.println("paradox");
                break;
            } else if (curr < K) {
                K -= curr;
            } else {
                K = curr - K;
                back++;
            }
        }
        if (K > 0) System.out.print(K + " ");
        System.out.println(back);
    }
}
//    Scanner in = new Scanner(System.in);
//    String[] str1 = in.nextLine().split(" ");
//    int K = Integer.parseInt(str1[0]);
//    int N = Integer.parseInt(str1[1]);
//    int sum  = 0;
//        for (int i = 0; i < N; i++) {
//        int curr = in.nextInt();
//        sum += curr;
//        if (sum == K) {
//        System.out.println("paradox");
//        break;
//        }
//        if (sum > K) {
//        System.out.print(K - (sum - curr) + " ");
//        System.out.println(sum - K);
//        break;
//        }
//        }