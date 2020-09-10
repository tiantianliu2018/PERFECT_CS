package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kelly
 * @create 2020-09-05 16:50
 */
public class solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        // 测试用例个数
        for (int t = 0; t < T; t++) {
            String[] s = in.nextLine().split(" ");
            int W = Integer.parseInt(s[0]);
            int H = Integer.parseInt(s[1]);
            char[][] back = new char[H][W];
            for (int i = 0; i < H; i++) {
                String line = in.nextLine();
                for (int j = 0; j < line.length(); j += 2) {
                    back[i][j] = line.charAt(j);
                }
            }
            s = in.nextLine().split(" ");
            int p = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);
            char[][] person = new char[q][p];
            for (int i = 0; i < q; i++) {
                String line = in.nextLine();
                for (int j = 0; j < line.length(); j += 2) {
                    person[i][j] = line.charAt(j);
                }
            }
            s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            int a = Integer.parseInt(s[2]), b = Integer.parseInt(s[3]);
            int res = getRes(back, person, x, y, p, q, W, H);

        }
    }

    private static int getRes(char[][] back, char[][] person, int x, int y, int p, int q, int w, int h) {
        int startH = 0;
        int startW = 0;
        int lenH = 0;
        int lenW = 0;
        if (x > 0) {
            startH = x;
            lenH = q + x;
        }
        lenH = Math.min(lenH, h - startH);
        if (y > 0) {
            startW = y;
            lenW = p + y;
        }
        lenW = Math.min(lenW, w - startW);
        return 0;
    }
}
