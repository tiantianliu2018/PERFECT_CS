package examples;

/**
 * @author Kelly
 * @create 2020-08-23 10:14
 */
public class ABCABCABC {
    private int flag = 0;
    public synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            while (flag != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            flag = 1;
            notify();
        }
    }
    public synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            while (flag != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            flag = 2;
            notifyAll();
        }
    }
    public synchronized void printC() {
        for (int i = 0; i < 5; i++) {
            while (flag != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("C");
            flag = 0;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ABCABCABC print = new ABCABCABC();
        new Thread(print::printA).start();
        new Thread(() -> {print.printB();}).start();
        new Thread(print::printC).start();
    }
}
