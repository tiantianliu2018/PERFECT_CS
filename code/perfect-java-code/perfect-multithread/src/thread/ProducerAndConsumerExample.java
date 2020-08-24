package thread;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerAndConsumerExample {
    private int queueSize = 1;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ProducerAndConsumerExample example = new ProducerAndConsumerExample();
        Producer producer = example.new Producer();
        Consumer consumer = example.new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            produce();
        }
        private void produce() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("向队列中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余 " + queue.size() + " 个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
