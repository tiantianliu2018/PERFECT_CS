package creation.factory.abstractfactory.pizzastore.order;

import creation.factory.abstractfactory.pizzastore.pizza.LDCheesePizza;
import creation.factory.abstractfactory.pizzastore.pizza.LDPepperPizza;
import creation.factory.abstractfactory.pizzastore.pizza.Pizza;

/**
 * @author Kelly
 * @create 2020-09-20 15:42
 */
public class LDFactory implements AbstractFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("===== 抽象工厂模式 ======");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
