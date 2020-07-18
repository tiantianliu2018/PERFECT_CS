package bytedance.math;

/**
 * @author Kelly
 * @create 2020-06-30 09:48
 *
 * 给定一个 0-4 随机数生成器 如何生成 0-6 随机数 ???
 */
public class RandomNumber {
    public static void main(String[] args) {
        int[] result = new int[7];
        for (int i = 0; i < 50000; i++) {
            int num = rand6();
            result[num]++;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println("num:" + i + " times: " + result[i]);
        }
    }
    public static int rand4() {
        double rand = Math.random() * 5;
        return (int) rand;
    }
    public static int rand6() {
        while (true) {
            int num = rand4() * 5 + rand4();
            if (num < 21) {
                return num % 7;
            }
        }
    }
}
