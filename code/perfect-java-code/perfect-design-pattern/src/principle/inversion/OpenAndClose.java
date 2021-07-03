package principle.inversion;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:10
 */
public class OpenAndClose implements IOpenAndClose{
    public ITV tv;

    public OpenAndClose() {
    }

    public OpenAndClose(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void setTV(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open(ITV tv) {
        tv.play();
    }

    public void open() {
        this.tv.play();
    }

    @Override
    public void close(ITV tv) {
        tv.close();
    }

    public void close() {
        this.tv.close();
    }
}
