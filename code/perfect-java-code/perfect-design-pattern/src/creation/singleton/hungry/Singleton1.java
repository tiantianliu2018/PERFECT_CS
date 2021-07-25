package creation.singleton.hungry;

/**
 * 饿汉式 静态代码块实现
 *
 * @author Kelly
 * @create 2021-07-25 10:10
 */
public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance;

    static {
        instance = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
