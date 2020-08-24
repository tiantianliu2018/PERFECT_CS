package thread;

/**
 * @author Kelly
 * @create 2020-08-24 11:17
 */
public class WaitNotifyDemo {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("Thread A " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "A").start();

        Thread.sleep(1000);

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("Thread B " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        },"B").start();
    }
}
