package Memory462119;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;

public class ParallelSum {

    private static final int NUMBER_OF_THREADS = 4;
    private static final int ARRAY_SIZE = 1000000;
    private static long[] numbers = new long[ARRAY_SIZE];

    public static void main(String[] args) {
        // Initialize the array with random numbers
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = (long) (Math.random() * 100);
        }

        long totalSum = parallelSum(numbers);
        System.out.println("Total Sum: " + totalSum);
    }

    private static long parallelSum(long[] numbers) {
        int chunkSize = ARRAY_SIZE / NUMBER_OF_THREADS;
        long[] partialSums = new long[NUMBER_OF_THREADS];
        CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadIndex = i;
            executor.submit(() -> {
                int start = threadIndex * chunkSize;
                int end = (threadIndex + 1 == NUMBER_OF_THREADS) ? ARRAY_SIZE : (threadIndex + 1) * chunkSize;
                long sum = 0;

                for (int j = start; j < end; j++) {
                    sum += numbers[j];
                }

                // Store the partial sum
                partialSums[threadIndex] = sum;
                latch.countDown(); // Decrease the count of the latch
            });
        }

        // Wait until all threads have completed their tasks
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown(); // Shutdown the executor service
        }

        // Combine the partial sums
        long totalSum = 0;
        for (long partialSum : partialSums) {
            totalSum += partialSum;
        }

        return totalSum;
    }
}