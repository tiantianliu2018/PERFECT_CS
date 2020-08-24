package examples;

/**
 * @author Kelly
 * @create 2020-08-24 10:05
 *
 * 多线程实现数字的加减
 */
class Resource {
    private int num = 0;
    private boolean flag = true; // 表示进行加减操作
    // 加法操作的同步方法
    public synchronized void add() {
        // 此时 flag = false，加法阻塞
        while (!flag) {
            try {
                System.out.println("【加法操作 - " + Thread.currentThread().getName() + ", 要进行等待】");
                wait();
                System.out.println("【加法操作 - " + Thread.currentThread().getName() + ", 被释放】");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.num++;
        System.out.println("【加法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
        flag = !flag;
        notifyAll();  // 唤醒所有等待的线程
    }

    // 减法操作的同步方法
    public synchronized void sub() {
        while (flag) {
            try {
                System.out.println("【减法操作 - " + Thread.currentThread().getName() + ", 要进行等待】");
                wait();
                System.out.println("【减法操作 - " + Thread.currentThread().getName() + ", 被释放】");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.num--;
        System.out.println("【减法操作 - " + Thread.currentThread().getName() + "】num = " + this.num);
        flag = !flag;
        notifyAll();
    }
}

// 加法线程
class AddThread implements Runnable {
    Resource resource;
    public AddThread(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 减法线程
class SubThread implements Runnable {
    Resource resource;
    public SubThread(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.resource.sub();
        }
    }
}

public class AddSubNums {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new AddThread(resource), "加法线程").start();
        new Thread(new SubThread(resource), "减法线程").start();
    }
}
