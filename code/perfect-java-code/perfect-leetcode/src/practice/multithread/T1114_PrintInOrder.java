package practice.multithread;

import java.util.concurrent.Semaphore;

/**
 * @author Kelly
 * @create 2020-08-15 11:51
 */
public class T1114_PrintInOrder {
    // 信号量实现顺序打印
    class Foo1 {
        private Semaphore s2;
        private Semaphore s3;
        public void Foo1() {
            s2 = new Semaphore(0);
            s3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) {
            printFirst.run();
            s2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            s2.acquire();
            printSecond.run();
            s3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            s3.acquire();
            printThird.run();
        }
    }
}
