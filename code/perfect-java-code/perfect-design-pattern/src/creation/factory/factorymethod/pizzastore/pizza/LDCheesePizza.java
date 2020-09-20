package creation.factory.factorymethod.pizzastore.pizza;

/**
 * @author Kelly
 * @create 2020-09-20 14:48
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪披萨");
        System.out.println("给【伦敦奶酪披萨】准备原材料...");
    }
}
