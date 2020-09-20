package creation.factory.factorymethod.pizzastore.pizza;

/**
 * @author Kelly
 * @create 2020-09-20 14:47
 */
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("给【北京奶酪披萨】准备原材料...");
    }
}
