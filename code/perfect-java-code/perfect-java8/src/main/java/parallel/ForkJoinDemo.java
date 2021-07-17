package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * @author Kelly
 * @create 2021-07-17 16:15
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        System.out.println(forkJoinSum(10000));
        System.out.println("ForkJoin sum done in: " + measureSumPref(ForkJoinDemo::forkJoinSum, 100000) + " msecs");
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> calculator = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(calculator);
    }

    public static long measureSumPref(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
