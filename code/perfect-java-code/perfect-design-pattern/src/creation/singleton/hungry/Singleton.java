package creation.singleton.hungry;

/**
 * 饿汉式 单例模式 静态常量实现
 * 优点：简单，在类装载时完成了实例的创建，避免线程同步，线程安全
 * 缺点：不能实现 lazy loading，浪费内存
 *
 * @author Kelly
 * @create 2021-07-25 09:53
 */
public class Singleton {
    // 1. 构造器私有化
    private Singleton() {
    }

    // 2. 本类内部创建一个对象实例
    private final static Singleton instance = new Singleton();

    // 3. 提供一个公有的静态方法 用来获取唯一的实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
