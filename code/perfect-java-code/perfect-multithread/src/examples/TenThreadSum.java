package examples;

/**
 * @author Kelly
 * @create 2020-08-23 10:22
 */
public class TenThreadSum {
    static class SumThread extends Thread {
        int cycle = 0;
        int sum = 0;
        SumThread(int cycle) {
            this.cycle = cycle;
        }
        @Override
        public void run() {
            // 10 个数相加
            for (int i = 1; i <= 10; i++) {
                sum += (i + cycle * 10);
            }
            System.out.println(Thread.currentThread().getName() + " : " + sum);
        }
    }

    public static void main(String[] args) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            SumThread sumThread = new SumThread(i);
            sumThread.start();
            try {
                sumThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res += sumThread.sum;
        }
        System.out.println("Result: " + res);
    }
}
