package creation.factory.factorymethod.pizzastore.order;

import creation.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import creation.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import creation.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author Kelly
 * @create 2020-09-20 15:01
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
