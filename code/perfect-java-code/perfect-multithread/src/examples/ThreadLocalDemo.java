package examples;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Kelly
 * @create 2020-08-24 11:34
 */
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                threadLocal.set("线程 " + finalI + " " + random.nextInt(10));
                System.out.println("当前线程 threadlocal 的值为：" + threadLocal.get());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
