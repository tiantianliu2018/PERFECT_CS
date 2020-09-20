package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:33
 *
 * Lazy Loading  懒汉式
 *
 * 通过对 getInstance 方法加锁，效率降低
 */
public class LazyLoadingSingleton2 {
    private static LazyLoadingSingleton2 instance;

    private LazyLoadingSingleton2() {}

    public static synchronized LazyLoadingSingleton2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazyLoadingSingleton2();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(LazyLoadingSingleton2.getInstance().hashCode())).start();
        }
    }
}
