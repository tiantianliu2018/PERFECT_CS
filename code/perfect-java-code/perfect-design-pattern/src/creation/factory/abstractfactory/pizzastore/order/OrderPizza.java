package creation.factory.abstractfactory.pizzastore.order;

import creation.factory.abstractfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kelly
 * @create 2020-09-20 15:44
 */
public class OrderPizza {
    AbstractFactory abstractFactory;

    public OrderPizza(AbstractFactory abstractFactory) {
        setAbstractFactory(abstractFactory);
    }

    public void setAbstractFactory(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
        Pizza pizza = null;
        String orderType = "";

        do {
            orderType = getType();
            pizza = abstractFactory.createPizza(orderType);
            if (pizza != null) {
                System.out.println("订购成功！");
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败...");
                break;
            }
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
