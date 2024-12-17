package Memory462107;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a mathematical vector.
 */
public class Vector2 {
    private List<Double> components;

    /**
     * Constructs a Vector with the given components.
     * 
     * @param components the components of the vector
     */
    public Vector2(List<Double> components) {
        this.components = new ArrayList<>(components);
    }

    /**
     * Adds another vector to this vector.
     * 
     * @param other the vector to be added
     * @return a new Vector that is the sum of this vector and the other vector
     */
    public Vector2 add(Vector2 other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        List<Double> resultComponents = new ArrayList<>();
        for (int i = 0; i < this.components.size(); i++) {
            resultComponents.add(this.components.get(i) + other.components.get(i));
        }

        return new Vector2(resultComponents);
    }

    /**
     * Multiplies this vector by a scalar.
     * 
     * @param scalar the scalar value
     * @return a new Vector that is the result of the scalar multiplication
     */
    public Vector2 multiplyByScalar(double scalar) {
        List<Double> resultComponents = new ArrayList<>();
        for (Double component : this.components) {
            resultComponents.add(component * scalar);
        }

        return new Vector2(resultComponents);
    }

    /**
     * Calculates the magnitude of the vector.
     * 
     * @return the magnitude of the vector
     */
    public double magnitude() {
        double sumOfSquares = 0.0;
        for (Double component : this.components) {
            sumOfSquares += component * component;
        }
        return Math.sqrt(sumOfSquares);
    }

    /**
     * Calculates the dot product of this vector with another vector.
     * 
     * @param other the vector to calculate the dot product with
     * @return the dot product of the two vectors
     */
    public double dotProduct(Vector2 other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        double dotProduct = 0.0;
        for (int i = 0; i < this.components.size(); i++) {
            dotProduct += this.components.get(i) * other.components.get(i);
        }
        return dotProduct;
    }

    /**
     * Calculates the cross product of this vector with another vector.
     * 
     * @param other the vector to calculate the cross product with
     * @return a new Vector that is the cross product of the two vectors
     */
    public Vector2 crossProduct(Vector2 other) {
        if (this.components.size() != 3 || other.components.size() != 3) {
            throw new IllegalArgumentException("Cross product is only defined for 3-dimensional vectors.");
        }

        double x1 = this.components.get(0);
        double y1 = this.components.get(1);
        double z1 = this.components.get(2);
        double x2 = other.components.get(0);
        double y2 = other.components.get(1);
        double z2 = other.components.get(2);

        List<Double> resultComponents = new ArrayList<>();
        resultComponents.add(y1 * z2 - z1 * y2); // i component
        resultComponents.add(z1 * x2 - x1 * z2); // j component
        resultComponents.add(x1 * y2 - y1 * x2); // k component

        return new Vector2(resultComponents);
    }

    /**
     * Returns the string representation of the vector.
     */
    @Override
    public String toString() {
        return components.toString();
    }

    // Test case to demonstrate functionality
    public static void main(String[] args) {
        List<Double> vector1Components = new ArrayList<>();
        vector1Components.add(2.0);
        vector1Components.add(3.0);
        vector1Components.add(4.0); // Added a 3rd dimension for cross product
          Vector2 vector1 = new Vector2(vector1Components);

        List<Double> vector2Components = new ArrayList<>();
        vector2Components.add(4.0);
        vector2Components.add(5.0);
        vector2Components.add(6.0); // Added a 3rd dimension for cross product
          Vector2 vector2 = new Vector2(vector2Components);

        // Vector addition
          Vector2 sum = vector1.add(vector2);
        System.out.println("Sum: " + sum); // Should print: Sum: [6.0, 8.0, 10.0]

        // Scalar multiplication
          Vector2 scaled = vector1.multiplyByScalar(2);
        System.out.println("Scaled: " + scaled); // Should print: Scaled: [4.0, 6.0, 8.0]

        // Magnitude
        double magnitude = vector1.magnitude();
        System.out.println("Magnitude of vector1: " + magnitude); // Should print: Magnitude of vector1: 5.385164807134504

        // Dot product
        double dotProduct = vector1.dotProduct(vector2);
        System.out.println("Dot Product: " + dotProduct); // Should print: Dot Product:  47.0

        // Cross product
          Vector2 crossProduct = vector1.crossProduct(vector2);
        System.out.println("Cross Product: " + crossProduct); // Should print the result of the cross product
    }
}