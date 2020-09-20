package creation.factory.abstractfactory.pizzastore.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println("给【北京胡椒披萨】准备原材料...");
    }
}
