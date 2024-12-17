package Memory462107;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a mathematical vector.
 */
public class Vector {
    private List<Double> components;

    /**
     * Constructs a Vector with the given components.
     * 
     * @param components the components of the vector
     */
    public Vector(List<Double> components) {
        this.components = new ArrayList<>(components);
    }

    /**
     * Adds another vector to this vector.
     * 
     * @param other the vector to be added
     * @return a new Vector that is the sum of this vector and the other vector
     */
    public Vector add(Vector other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        List<Double> resultComponents = new ArrayList<>();
        for (int i = 0; i < this.components.size(); i++) {
            resultComponents.add(this.components.get(i) + other.components.get(i));
        }

        return new Vector(resultComponents);
    }

    /**
     * Multiplies this vector by a scalar.
     * 
     * @param scalar the scalar value
     * @return a new Vector that is the result of the scalar multiplication
     */
    public Vector multiplyByScalar(double scalar) {
        List<Double> resultComponents = new ArrayList<>();
        for (Double component : this.components) {
            resultComponents.add(component * scalar);
        }

        return new Vector(resultComponents);
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
        Vector vector1 = new Vector(vector1Components);

        List<Double> vector2Components = new ArrayList<>();
        vector2Components.add(4.0);
        vector2Components.add(5.0);
        Vector vector2 = new Vector(vector2Components);

        // Vector addition
        Vector sum = vector1.add(vector2);
        System.out.println("Sum: " + sum); // Should print: Sum: [6.0, 8.0]

        // Scalar multiplication
        Vector scaled = vector1.multiplyByScalar(2);
        System.out.println("Scaled: " + scaled); // Should print: Scaled: [4.0, 6.0]

        // Magnitude
        double magnitude = vector1.magnitude();
        System.out.println("Magnitude of vector1: " + magnitude); // Should print: Magnitude of vector1: 3.605551275463989
    }
}