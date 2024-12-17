/*package Memory462098;
import java.util.concurrent.*;

public class ConcurrentWebCache {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    private final static int NUM_THREADS = 100;
    private final static int NUM_REQUESTS = 1000;
    private final static String[] URLS = new String[]{
            "https://www.example.com", "https://www.example.org", "https://www.example.net",
            "https://www.example.info", "https://www.example.edu" // Added more URLs for variety
    };

    
    private String fetchContentFromWeb(String url) {

      try {
            Thread.sleep(Math.random() * 1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url + "-content";
    }

    public void cacheWebPageContent() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_REQUESTS; i++) {
            final String url = URLS[(int) (Math.random() * URLS.length)];
            executor.submit(() -> {
                String cachedContent = cache.get(url);
                if (cachedContent == null) {
                    String contentFromWeb = fetchContentFromWeb(url);
                    cache.put(url, contentFromWeb);
                    System.out.println(Thread.currentThread().getName() + ": Cached content for " + url);
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Retrieved content for " + url + " from cache");
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConcurrentWebCache().cacheWebPageContent();
    }
}*/