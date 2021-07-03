package principle.inversion;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:06
 */
public class DependencyPass {
    public static void main(String[] args) {
        // 通过接口传递实现依赖
        ChangHong changHong = new ChangHong();
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changHong);
        openAndClose.close(changHong);

        // 通过构造器进行依赖传递
        OpenAndClose openAndClose1 = new OpenAndClose(changHong);
        openAndClose1.open();
        openAndClose1.close();

        // 通过 setter 方法传递

    }
}
