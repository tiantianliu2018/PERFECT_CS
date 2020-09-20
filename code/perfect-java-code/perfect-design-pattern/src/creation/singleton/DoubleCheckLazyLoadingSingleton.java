package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:37
 */
public class DoubleCheckLazyLoadingSingleton {
    private static volatile DoubleCheckLazyLoadingSingleton instance;

    private DoubleCheckLazyLoadingSingleton() {}

    public static DoubleCheckLazyLoadingSingleton getInstance() {
        // 双重检查
        if (instance == null) {
            synchronized (DoubleCheckLazyLoadingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazyLoadingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(DoubleCheckLazyLoadingSingleton.getInstance().hashCode())).start();
        }
    }
}
