package creation.singleton.hungry;

/**
 * @author Kelly
 * @create 2021-07-25 10:14
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode: " + instance.hashCode());
        System.out.println("instance1.hashCode: " + instance1.hashCode());
    }
}
