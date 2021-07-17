package designpattern.observer;

/**
 * @author Kelly
 * @create 2021-07-17 18:09
 */
public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}
