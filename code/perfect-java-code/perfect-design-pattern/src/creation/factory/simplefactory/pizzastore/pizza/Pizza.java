package creation.factory.simplefactory.pizzastore.pizza;

/**
 * @author Kelly
 * @create 2020-09-18 16:28
 */
public abstract class Pizza {
    protected String name;
    // 准备原材料
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking...");
    }

    public void cut() {
        System.out.println(name + " cutting...");
    }

    public void box() {
        System.out.println(name + " boxing...");
    }

    public void setName(String name) {
        this.name = name;
    }
}
