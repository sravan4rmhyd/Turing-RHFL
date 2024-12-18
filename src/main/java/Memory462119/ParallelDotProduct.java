package Memory462119;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ParallelDotProduct {

    private static final int NUMBER_OF_THREADS = 4;
    private static final int VECTOR_SIZE = 1000000;
    private static long[] vectorA = new long[VECTOR_SIZE];
    private static long[] vectorB = new long[VECTOR_SIZE];
    private static long result = 0;
    private static final Semaphore semaphore = new Semaphore(1);  // Only one thread can access the critical section at a time

    public static void main(String[] args) {
        // Initialize vectors with random numbers
        for (int i = 0; i < VECTOR_SIZE; i++) {
            vectorA[i] = (long) (Math.random() * 100);
            vectorB[i] = (long) (Math.random() * 100);
        }

        long dotProduct = parallelDotProduct(vectorA, vectorB);
        System.out.println("Dot Product: " + dotProduct);
    }

    private static long parallelDotProduct(long[] vectorA, long[] vectorB) {
        int chunkSize = VECTOR_SIZE / NUMBER_OF_THREADS;
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                long partialResult = 0;
                int start = threadIndex * chunkSize;
                int end = (threadIndex + 1 == NUMBER_OF_THREADS) ? VECTOR_SIZE : (threadIndex + 1) * chunkSize;

                for (int j = start; j < end; j++) {
                    partialResult += vectorA[j] * vectorB[j];
                }

                // Critical section: update the shared result using semaphore
                try {
                    semaphore.acquire();  // Acquire the semaphore
                    result += partialResult;  // Update the shared result
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Restore interrupted status
                } finally {
                    semaphore.release();  // Always release the semaphore in a finally block
                }
            });
            threads[i].start();  // Start each thread
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();  // Wait for the thread to finish
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // Restore interrupted status
            }
        }

        return result;  // Return the final dot product result
    }
}