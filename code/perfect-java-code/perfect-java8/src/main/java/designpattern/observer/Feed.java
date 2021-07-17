package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly
 * @create 2021-07-17 18:10
 */
public class Feed implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
