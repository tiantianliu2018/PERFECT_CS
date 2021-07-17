package lambda;

/**
 * @author Kelly
 * @create 2021-07-07 20:26
 */
public class LambdaDemo1 {
    interface Printer{
        void printer(String val);
    }

    public void printSomething(String something, Printer printer) {
        printer.printer(something);
    }

    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();
        String something = "abcd";
//        Printer printer = new Printer() {
//            @Override
//            public void printer(String val) {
//                System.out.println(val);
//            }
//        };
//        Printer printer = (String val) -> {
//            System.out.println(val);
//        };
        Printer printer = System.out::println;

        lambdaDemo1.printSomething(something, printer);
        lambdaDemo1.printSomething(something, val -> System.out.println(val));
        lambdaDemo1.printSomething(something, System.out::println);
    }
}
