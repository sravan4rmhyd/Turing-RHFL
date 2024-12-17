package Memory462084;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceManagementExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // BufferedReader is automatically closed, releasing resources.
    }
}