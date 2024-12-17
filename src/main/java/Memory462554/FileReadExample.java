package Memory462554;
import java.io.*;
import java.nio.file.*;

public class FileReadExample {
    public static void main(String[] args) {
        // Reading file using Java IO
        System.out.println("Reading file using Java IO:");
        try (BufferedReader br = new BufferedReader(new FileReader("src/file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading file using Java NIO
        System.out.println("Reading file using Java NIO:");
        try {
            Path path = Paths.get("src/file.txt");
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}