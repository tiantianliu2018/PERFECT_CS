package creation.factory.simplefactory.pizzastore.pizza;

/**
 * @author Kelly
 * @create 2020-09-18 16:32
 */
public class CheesePizza extends Pizza  {
    @Override
    public void prepare() {
        System.out.println("给【奶酪披萨】准备原材料...");
    }
}
