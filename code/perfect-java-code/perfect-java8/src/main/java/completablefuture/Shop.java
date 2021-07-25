package completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author Kelly
 * @create 2021-07-18 14:42
 */
public class Shop {
    String name;

    public Shop(String name) {
        this.name = name;
    }

    Random random = new Random();


    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }

        }).start();

        // 使用工厂方法supplyAsync创建CompletableFuture
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));

//        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
