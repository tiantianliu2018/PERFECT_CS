package principle.inversion;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:09
 */
public class ChangHong implements ITV{
    @Override
    public void play() {
        System.out.println("ChangHong play ~");
    }

    @Override
    public void close() {
        System.out.println("ChangHong close ~");
    }
}
