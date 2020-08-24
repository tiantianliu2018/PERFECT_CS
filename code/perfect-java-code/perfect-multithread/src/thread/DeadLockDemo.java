package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Kelly
 * @create 2020-08-15 11:49
 *
 * 死锁 Demo
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String A = "Resource-A";
        String B = "Resource-B";
        new Thread(new HoldLockThread(A, B), "Thread-1").start();
        new Thread(new HoldLockThread(B, A), "Thread-2").start();
    }
}
// 线程类，实现 Runnable 接口
class HoldLockThread implements Runnable {
    // 两个资源 A, B
    private String A;
    private String B;
    public HoldLockThread(String A, String B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public void run() {
        // 线程方法里面，先对 A 加锁，然后对 B 加锁
        synchronized (A) {
            System.out.println(Thread.currentThread().getName() + " 持有：" + A + "\t尝试获取：" + B);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + " 持有：" + B + "\t尝试获取：" + A);
            }
        }
    }
}