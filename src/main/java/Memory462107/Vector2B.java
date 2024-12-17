package Memory462107;
import java.util.ArrayList;
import java.util.List;

public class Vector2B {
    private List<Double> components;

    public Vector2B(List<Double> components) {
        this.components = new ArrayList<>(components);
    }

    public Vector2B add(Vector2B other) {
        if (components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        List<Double> resultComponents = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            resultComponents.add(components.get(i) + other.components.get(i));
        }

        return new Vector2B(resultComponents);
    }

    public Vector2B multiplyByScalar(double scalar) {
        List<Double> resultComponents = new ArrayList<>();
        for (Double component : components) {
            resultComponents.add(component * scalar);
        }

        return new Vector2B(resultComponents);
    }

    public double magnitude() {
        double sumOfSquares = 0.0;
        for (Double component : components) {
            sumOfSquares += component * component;
        }
        return Math.sqrt(sumOfSquares);
    }

    public double dotProduct(Vector2B other) {
        if (components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension for dot product.");
        }

        double dotProduct = 0.0;
        for (int i = 0; i < components.size(); i++) {
            dotProduct += components.get(i) * other.components.get(i);
        }

        return dotProduct;
    }

    public Vector2B crossProduct(Vector2B other) {
        if (components.size() != other.components.size() || components.size() != 3) {
            throw new IllegalArgumentException("Cross product is only defined for 3D vectors.");
        }

        double i = components.get(1) * other.components.get(2) - components.get(2) * other.components.get(1);
        double j = components.get(2) * other.components.get(0) - components.get(0) * other.components.get(2);
        double k = components.get(0) * other.components.get(1) - components.get(1) * other.components.get(0);

        return new Vector2B(List.of(i, j, k));
    }

    @Override
    public String toString() {
        return components.toString();
    }

    public static void main(String[] args) {
        List<Double> vector1Components = List.of(1.0, 2.0, 3.0);
            Vector2B vector1 = new Vector2B(vector1Components);

        List<Double> vector2Components = List.of(4.0, 5.0, 6.0);
            Vector2B vector2 = new Vector2B(vector2Components);

        // Vector addition
            Vector2B sum = vector1.add(vector2);
        System.out.println("Sum: " + sum);        // Output: Sum: [5.0, 7.0, 9.0]

        // Scalar multiplication
            Vector2B scaled = vector1.multiplyByScalar(2);
        System.out.println("Scaled: " + scaled); // Output: Scaled: [2.0, 4.0, 6.0]

        // Dot product
        double dotProduct = vector1.dotProduct(vector2);
        System.out.println("Dot product: " + dotProduct); // Output: Dot product: 32.0

        // Cross product
            Vector2B crossProduct = vector1.crossProduct(vector2);
        System.out.println("Cross product: " + crossProduct); // Output: Cross product: [-3.0, 6.0, -3.0]
    }
} 