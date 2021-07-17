package designpattern.observer;

/**
 * @author Kelly
 * @create 2021-07-17 18:21
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
