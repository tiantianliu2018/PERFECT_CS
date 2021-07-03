package principle.inversion;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:10
 */
public interface IOpenAndClose {
    public void open(ITV tv);
    public void close(ITV tv);

    public void setTV(ITV tv);
}
