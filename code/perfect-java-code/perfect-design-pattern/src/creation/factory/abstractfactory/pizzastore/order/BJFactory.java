package creation.factory.abstractfactory.pizzastore.order;

import creation.factory.abstractfactory.pizzastore.pizza.BJCheesePizza;
import creation.factory.abstractfactory.pizzastore.pizza.BJPepperPizza;
import creation.factory.abstractfactory.pizzastore.pizza.Pizza;

/**
 * @author Kelly
 * @create 2020-09-20 15:41
 */
public class BJFactory implements AbstractFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("===== 抽象工厂模式 ======");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
