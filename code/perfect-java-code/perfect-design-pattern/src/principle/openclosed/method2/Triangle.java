package principle.openclosed.method2;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:49
 */
public class Triangle extends Shape{
    public Triangle() {
        super.type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形~~");
    }
}
