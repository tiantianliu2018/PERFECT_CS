package principle.openclosed.method2;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:48
 */
public class Circle extends Shape{
    public Circle() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形~~");
    }
}
