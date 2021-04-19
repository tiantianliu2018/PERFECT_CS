package com.learn.chapter01.test;

/**
 * @author Kelly
 * @create 2021-04-19 11:08
 */
public class TestScala {
    public static void main(String[] args) {
//        TestScala..MODULE$.main(args);
        TestScala$.MODULES$.main(args);
    }
}
final class TestScala${
    public static final TestScala$ MODULES$;

    static {
        MODULES$ = new TestScala$();
    }

    public void main(String[] args) {
        System.out.println("Hello Scala, idea...");
    }
}
