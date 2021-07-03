package principle.openclosed.method2;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:47
 */
public class Rectangle extends Shape{
    public Rectangle() {
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形~~");
    }
}
