package principle.openclosed.method1;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:28
 */
public class GraphicEditor {
    public void drawShape(Shape shape) {
        if (shape.type == 1) {
            drawRectangle(shape);
        } else if (shape.type == 2) {
            drawCircle(shape);
        } else if (shape.type == 3) {
            drawTriangle(shape);
        }
    }

    private void drawTriangle(Shape shape) {
        System.out.println("绘制三角形");
    }

    private void drawCircle(Shape shape) {
        System.out.println("绘制圆形");
    }

    private void drawRectangle(Shape shape) {
        System.out.println("绘制矩形");
    }

}
