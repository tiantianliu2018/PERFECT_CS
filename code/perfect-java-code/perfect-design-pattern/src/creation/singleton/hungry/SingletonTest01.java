package creation.singleton.hungry;

/**
 * @author Kelly
 * @create 2021-07-25 10:08
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton instance = Singleton.getInstance();
        System.out.println(singleton == instance);
        System.out.println("singleton.hashCode: " + singleton.hashCode());
        System.out.println("instance.hashCode: " + instance.hashCode());
    }
}
