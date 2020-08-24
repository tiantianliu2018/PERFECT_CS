package examples;

/**
 * @author Kelly
 * @create 2020-08-23 09:48
 */
public class SequentialPrint {
    static class PrintThread extends Thread {
        PrintThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public static void main(String[] args) {
        PrintThread t1 = new PrintThread("A");
        PrintThread t2 = new PrintThread("B");
        PrintThread t3 = new PrintThread("C");

        try {
            t1.start();
            t1.join(); // 等待线程 1 执行完，才执行其他线程

            t2.start();
            t2.join();

            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
