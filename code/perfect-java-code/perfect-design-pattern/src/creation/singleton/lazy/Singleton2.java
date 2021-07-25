package creation.singleton.lazy;

/**
 * 懒汉式 同步代码块
 *
 * @author Kelly
 * @create 2021-07-25 10:40
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    private static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                instance = new Singleton2();
            }
        }
        return instance;
    }

}
