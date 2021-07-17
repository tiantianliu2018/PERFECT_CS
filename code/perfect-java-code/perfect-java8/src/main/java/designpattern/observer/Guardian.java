package designpattern.observer;

/**
 * @author Kelly
 * @create 2021-07-17 18:06
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
