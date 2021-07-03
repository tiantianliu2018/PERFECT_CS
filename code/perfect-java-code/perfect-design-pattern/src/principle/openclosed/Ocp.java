package principle.openclosed;

import principle.openclosed.method1.Circle;
import principle.openclosed.method1.GraphicEditor;
import principle.openclosed.method1.Rectangle;
import principle.openclosed.method1.Triangle;
import principle.openclosed.method2.GraphicPainter;

/**
 * @author Kelly
 * @description
 * @create 2021-07-03 12:26
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(new Rectangle());
        editor.drawShape(new Circle());
        editor.drawShape(new Triangle());
        System.out.println("---------------");
        drawShape();
    }

    public static void drawShape() {
        GraphicPainter painter = new GraphicPainter();
        painter.drawShape(new principle.openclosed.method2.Rectangle());
        painter.drawShape(new principle.openclosed.method2.Circle());
        painter.drawShape(new principle.openclosed.method2.Triangle());
    }
}
