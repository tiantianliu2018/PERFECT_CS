package examples;

/**
 * @author Kelly
 * @create 2020-08-24 09:30
 */
class TicketThread implements Runnable {
    int number = 30;

    @Override
    public void run() {
        while (number > 0) {
            synchronized (this) {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖出一张票，票数是：" + --this.number);
                } else {
                    System.out.println("票已经卖完了");
                    break;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread, "卖票员 A").start();
        new Thread(ticketThread, "卖票员 B").start();
        new Thread(ticketThread, "卖票员 C").start();
    }

}
