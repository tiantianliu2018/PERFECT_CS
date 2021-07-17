package designpattern.strategy;

/**
 * @author Kelly
 * @create 2021-07-17 17:54
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
