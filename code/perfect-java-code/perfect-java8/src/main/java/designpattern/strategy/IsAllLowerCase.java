package designpattern.strategy;

/**
 * @author Kelly
 * @create 2021-07-17 17:51
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
