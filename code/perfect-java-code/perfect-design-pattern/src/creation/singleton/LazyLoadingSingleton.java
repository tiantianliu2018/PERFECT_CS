package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:19
 *
 * lazy loading 懒汉式
 * 线程不安全的单例模式
 */
public class LazyLoadingSingleton {
    private static LazyLoadingSingleton instance;
    // 私有的构造方法
    private LazyLoadingSingleton() {}

    public static LazyLoadingSingleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazyLoadingSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(LazyLoadingSingleton.getInstance().hashCode());
            }).start();
        }
    }
}
