package creation.singleton.lazy;

/**
 * 懒汉式 线程安全
 *
 * @author Kelly
 * @create 2021-07-25 10:35
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
