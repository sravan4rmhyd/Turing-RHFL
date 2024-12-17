package Memory462098;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCountApp {

    // ConcurrentHashMap to store word frequencies
    private static final ConcurrentHashMap<String, Integer> wordCountMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // Sample data simulating lines of text
        String[] lines = {
            "Hello world",
            "Hello from the other side",
            "World of concurrent programming",
            "Java concurrency is powerful",
            "Hello concurrency",
            "Concurrent programming in Java"
        };

        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit word counting tasks for each line
        for (String line : lines) {
            executorService.submit(() -> countWords(line));
        }

        // Shut down the executor service
        executorService.shutdown();

        // Wait for all tasks to complete
        while (!executorService.isTerminated()) {
            // Wait for tasks to finish
        }

        // Display the word counts
        wordCountMap.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    private static void countWords(String line) {
        String[] words = line.split("\\s+"); // Split the line into words
        for (String word : words) {
            // Update the count in the ConcurrentHashMap
            wordCountMap.merge(word.toLowerCase(), 1, Integer::sum);
        }
    }
}