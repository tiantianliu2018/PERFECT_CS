package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:11
 *
 * 饿汉式
 * 类加载到内存以后，就创建一个实例对象，由 JVM 保证线程安全
 * 缺点：无论用到与否，类加载时，都要进行实例化
 */
public class Singleton {
    // 私有静态变量
    private static Singleton instance = new Singleton();
    // 私有构造方法
    private Singleton() {}
    // public 的静态方法，返回一个实例
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
