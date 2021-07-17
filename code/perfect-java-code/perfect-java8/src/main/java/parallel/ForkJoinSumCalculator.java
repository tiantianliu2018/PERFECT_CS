package parallel;

import java.util.concurrent.RecursiveTask;

/**
 * @author Kelly
 * @create 2021-07-17 16:05
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private long[] numbers;

    private int start;

    private int end;

    private static final long THRESHOLD = 10000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long leftResult = leftTask.compute();
        Long rightResult = rightTask.join();
        return leftResult + rightResult;
    }

    /**
     * 顺序计算
     *
     * @return
     */
    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
