package creation.factory.abstractfactory.pizzastore.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("给【北京奶酪披萨】准备原材料...");
    }
}
