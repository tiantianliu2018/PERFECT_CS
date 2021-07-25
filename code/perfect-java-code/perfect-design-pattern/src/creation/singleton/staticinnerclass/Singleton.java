package creation.singleton.staticinnerclass;

/**
 * 静态内部类实现
 *
 * @author Kelly
 * @create 2021-07-25 10:52
 */
public class Singleton {
    private static volatile Singleton instance;

    // 构造器私有化
    private Singleton() {
    }

    // 静态内部类
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
