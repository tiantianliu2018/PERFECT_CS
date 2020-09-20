package creation.singleton;

/**
 * @author Kelly
 * @create 2020-09-18 15:49
 *
 * 不仅可以保证线程同步，而且可以防止反序列化
 */
public enum EnumSingleton {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(EnumSingleton.INSTANCE.hashCode());
        }
    }

}
