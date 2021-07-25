package creation.singleton.lazy;

/**
 * 懒汉式 线程不安全
 *
 * @author Kelly
 * @create 2021-07-25 10:17
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    // 提供一个公有的静态方法，当需要用到实例对象时才创建
    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
