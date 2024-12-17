package Memory462107;
import java.util.List;
public class VectorTest {
    public static void main(String[] args) {
        VectorB vector1 = new VectorB(List.of(2.0, 3.0));
          VectorB vector2 = new VectorB(List.of(4.0, 5.0));
          VectorB sumVector = vector1.add(vector2);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Vector 2: " + vector2);
        System.out.println("Sum of Vector 1 and Vector 2: " + sumVector); // Output: [6.0, 8.0]

        double scalar = 2.0;
        Vector scalarMultipliedVector = vector1.multiplyByScalar(scalar);

        System.out.println("Vector 1 multiplied by " + scalar + ": " + scalarMultipliedVector);  // Output: [4.0, 6.0]

        double magnitude = scalarMultipliedVector.magnitude();
        System.out.println("Magnitude of the resulting vector: " + magnitude); // Output: 7.211102550927978
    }
}