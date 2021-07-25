package uml.classgraph.association;

/**
 * @author Kelly
 * @create 2021-07-25 09:35
 */
public class Computer {
    private Mouse mouse;

    private Monitor monitor;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
