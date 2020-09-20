package creation.factory.simplefactory.pizzastore.pizza;

/**
 * @author Kelly
 * @create 2020-09-18 16:35
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给【希腊披萨】准备原材料...");
    }
}
