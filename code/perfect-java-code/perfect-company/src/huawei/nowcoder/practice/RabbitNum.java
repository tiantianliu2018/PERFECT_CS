package huawei.nowcoder.practice;

import java.util.Scanner;

/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class RabbitNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            int count = getTotalCount(n);
            System.out.println(count);
        }
    }
    /**
     * 统计出兔子总数。
     * 递推公式：f(n) = f(n-1) + f(n-2)  上个月的兔子 + 有生育能力的兔子
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i < monthCount; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
