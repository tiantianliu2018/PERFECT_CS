package thread;

import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumerExample {
    class Producer implements Runnable {
        private final BlockingQueue queue;

        Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

        }
    }
}
