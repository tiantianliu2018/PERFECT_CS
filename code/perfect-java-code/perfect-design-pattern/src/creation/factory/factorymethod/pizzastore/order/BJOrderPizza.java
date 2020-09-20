package creation.factory.factorymethod.pizzastore.order;

import creation.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import creation.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import creation.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author Kelly
 * @create 2020-09-20 14:58
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else  if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
