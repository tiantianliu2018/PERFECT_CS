package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:45
 *
 * 懒汉式 -- 静态内部类
 */
public class Singleton2 {
    private Singleton2() {}

    private static class SingletonHolder {
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton2.getInstance().hashCode())).start();
        }
    }
}
