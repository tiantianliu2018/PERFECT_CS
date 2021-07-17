package designpattern.strategy;

/**
 * @author Kelly
 * @create 2021-07-17 17:55
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numberValidator = new Validator(new IsNumeric());
        boolean aaaa = numberValidator.validate("aaaa");
        System.out.println(aaaa);

        Validator characterValidator = new Validator(new IsAllLowerCase());
        boolean bbbbb = characterValidator.validate("bbbbb");
        System.out.println(bbbbb);

    }
}
