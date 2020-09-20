package creation.factory.abstractfactory.pizzastore.order;

import creation.factory.abstractfactory.pizzastore.pizza.Pizza;

/**
 * @author Kelly
 * @create 2020-09-20 15:39
 */

// 一个抽象工厂模式的抽象层
public interface AbstractFactory {
    public Pizza createPizza(String orderType);
}
