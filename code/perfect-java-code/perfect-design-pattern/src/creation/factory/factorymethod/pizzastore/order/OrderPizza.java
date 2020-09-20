package creation.factory.factorymethod.pizzastore.order;


import creation.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kelly
 * @create 2020-09-20 14:51
 */
public abstract class OrderPizza {
    // 定义一个抽象方法 createPizza, 让各个工厂子类自己去实现
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }

    private String getType() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input pizza type: ");
            String type = null;
            type = br.readLine();
            return type;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
