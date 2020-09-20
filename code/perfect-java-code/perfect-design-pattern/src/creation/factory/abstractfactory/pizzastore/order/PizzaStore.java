package creation.factory.abstractfactory.pizzastore.order;

import creation.factory.factorymethod.pizzastore.order.BJOrderPizza;

/**
 * @author Kelly
 * @create 2020-09-20 15:03
 */
public class PizzaStore {
    public static void main(String[] args) {
        // 创建北京各种口味的披萨
//        new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }

}
