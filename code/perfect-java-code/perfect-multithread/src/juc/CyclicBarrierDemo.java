package juc;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Kelly
 * @create 2020-08-24 10:58
 */
public class CyclicBarrierDemo {
    static class PreTaskThread implements Runnable {
        private String task;
        private CyclicBarrier cyclicBarrier;
        public PreTaskThread(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡 %d 的任务 %s 完成", i, task));
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 重置屏障
                cyclicBarrier.reset();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("所有前置任务完成，开始游戏...");
        });
        new Thread(new PreTaskThread("加载地图", cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载模型", cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载音乐", cyclicBarrier)).start();
    }
}
