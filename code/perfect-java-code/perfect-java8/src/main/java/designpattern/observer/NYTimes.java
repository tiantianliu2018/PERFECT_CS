package designpattern.observer;

/**
 * @author Kelly
 * @create 2021-07-17 18:05
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
