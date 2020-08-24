package examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kelly
 * @create 2020-08-24 09:21
 */
class Ticket {
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "\t卖出第：" + (number--) + "，还剩下：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "Thread-A").start();

        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}, "Thread-B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}, "Thread-C").start();
    }
}
