/*package Memory462119;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelMonteCarloPi {

    private static final int NUM_THREADS = 4;
    private static final int ITERATIONS_PER_THREAD = 1_000_000; 
    private static final AtomicInteger inCircleCount = new AtomicInteger(0);
    private static final AtomicLong totalIterations = new AtomicLong(0);

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < NUM_THREADS; i++) {
            tasks.add(new MonteCarloTask());
        }

        executorService.invokeAll(tasks);
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double piEstimate = calculatePi();
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000; 

        System.out.println("Estimated value of Pi: " + piEstimate);
        System.out.println("Execution time: " + executionTime + " ms");
    }

    private static double calculatePi() {
        double insideCircleRatio = (double) inCircleCount.get() / totalIterations.get();
        return 4.0 * insideCircleRatio;
    }

    static class MonteCarloTask implements Runnable {

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < ITERATIONS_PER_THREAD; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();

                if (x * x + y * y <= 1) {
                    inCircleCount.incrementAndGet();
                }
                totalIterations.incrementAndGet();
            }
        }
    }
}*/