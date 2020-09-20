package creation.factory.abstractfactory.pizzastore.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的胡椒披萨");
        System.out.println("给【伦敦胡椒披萨】准备原材料...");
    }
}
