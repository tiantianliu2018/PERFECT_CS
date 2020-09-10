package examples;

/**
 * @author Kelly
 * @create 2020-08-23 09:55
 *
 * 两个线程轮流打印数字，一直到100
 */
public class AlternatePrint {
    static class PrintThread {
        private boolean flag = true;
        private int count = 0;
        // 同步方法
        public synchronized void print1() {
            for (int i = 1; i <= 50; i++) {
                // 当 flag 为 false，阻塞线程
                while (!flag) {
                    try {
//                        System.out.println("Print1: wait before");
                        wait();
//                        System.out.println("Print2: wait after");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print1: " + ++count);
                flag = !flag;
                notifyAll();
            }
        }
        public synchronized void print2() {
            for (int i = 1; i <= 50; i++) {
                while (flag) {
                    try {
//                        System.out.println("Print2: wait before");
                        wait();
//                        System.out.println("Print2: wait after");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print2: " + ++count);
                flag = !flag;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        new Thread(() -> printThread.print1()).start();

        new Thread(() -> printThread.print2()).start();
    }
}
