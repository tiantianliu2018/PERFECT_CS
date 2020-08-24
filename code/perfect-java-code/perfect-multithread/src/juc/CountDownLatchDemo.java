package juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Kelly
 * @create 2020-08-24 10:30
 */
public class CountDownLatchDemo {
    static class PreTaskThread implements Runnable {
        private String task;
        private CountDownLatch countDownLatch;

        public PreTaskThread(String task, CountDownLatch countDownLatch){
            this.task = task;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("【" + task + "】任务完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                System.out.println("等待数据加载...");
                System.out.println(String.format("还有 %d 个前置任务等待加载", countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("数据加载完成，游戏开始！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"MainThread").start();

        new Thread(new PreTaskThread("加载地图",countDownLatch)).start();
        new Thread(new PreTaskThread("加载人物",countDownLatch)).start();
        new Thread(new PreTaskThread("加载音乐",countDownLatch)).start();
    }
}
