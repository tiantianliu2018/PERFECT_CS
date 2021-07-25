package creation.singleton.lazy;

/**
 * 懒汉式 线程安全 双重检查 （推荐）
 *
 * @author Kelly
 * @create 2021-07-25 10:45
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
