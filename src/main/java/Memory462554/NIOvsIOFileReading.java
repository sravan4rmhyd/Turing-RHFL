/*package Memory462554;
import java.io.BufferedReader;
  import java.io.FileReader;
  import java.io.IOException;
  import java.nio.CharBuffer;
  import java.nio.channels.Channels;
  import java.nio.channels.FileChannel;
  import java.nio.file.Files;
  import java.nio.file.Paths;

  public class NIOvsIOFileReading {

      public static void main(String[] args) {
          readFileUsingIO();
          readFileUsingNIO();
      }

      private static void readFileUsingIO() throws IOException {
          String filePath = "example.txt";
          BufferedReader reader = new BufferedReader(new FileReader(filePath));
          String line;
          while ((line = reader.readLine()) != null) {
              System.out.println(line);
          }
          reader.close();
      }

      private static void readFileUsingNIO() throws IOException {
          String filePath = "example.txt";
          Path file = Paths.get(filePath);
          byte[] data = Files.readAllBytes(file);
          String content = new String(data);
          System.out.println(content);
      }
  }*/