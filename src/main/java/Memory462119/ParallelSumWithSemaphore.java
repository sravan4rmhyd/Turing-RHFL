package Memory462119;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ParallelSumWithSemaphore {

    private static final int NUMBER_OF_THREADS = 4;
    private static final int ARRAY_SIZE = 1000000;
    private static long[] numbers = new long[ARRAY_SIZE];
    private static final int CHUNK_SIZE = ARRAY_SIZE / NUMBER_OF_THREADS;
    private static long[] partialSums = new long[NUMBER_OF_THREADS];
    private static Semaphore semaphore = new Semaphore(NUMBER_OF_THREADS * 2); // Allow double the number of threads to access the shared resource simultaneously

    public static void main(String[] args) {
        // Initialize the array with random numbers
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = (long) (Math.random() * 100);
        }

        long totalSum = parallelSum(numbers);
        System.out.println("Total Sum: " + totalSum);
    }

    private static long parallelSum(long[] numbers) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadIndex = i;
            executor.submit(() -> {
                int start = threadIndex * CHUNK_SIZE;
                int end = (threadIndex + 1 == NUMBER_OF_THREADS) ? ARRAY_SIZE : (threadIndex + 1) * CHUNK_SIZE;
                long sum = 0;

                try {
                    // Acquire permits before accessing shared resources
                    semaphore.acquire();
                    for (int j = start; j < end; j++) {
                        sum += numbers[j];
                    }

                    // Store the partial sum
                    partialSums[threadIndex] = sum;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Release permits after accessing shared resources
                    semaphore.release();
                }
            });
        }

        executor.shutdown();

        // Wait for all threads to complete
        executor.awaitTermination();

        // Combine the partial sums
        long totalSum = 0;
        for (long partialSum : partialSums) {
            totalSum += partialSum;
        }

        return totalSum;
    } 
}