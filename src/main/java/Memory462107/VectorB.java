package Memory462107;
import java.util.ArrayList;
import java.util.List;

public class VectorB {
    private final List<Double> components;

    /**
     * Constructor that creates an empty vector.
     */
    public VectorB() {
        this.components = new ArrayList<>();
    }

    /**
     * Constructor that creates a vector from a list of components.
     * @param components The list of components to initialize the vector with.
     */
    public VectorB(List<Double> components) {
        this.components = components;
    }

    /**
     * Get the number of components in this vector.
     * @return The dimension of the vector.
     */
    public int dimension() {
        return components.size();
    }

    /**
     * Get the component at the specified index.
     * @param index The index of the component to retrieve (0-based).
     * @return The value of the component at the specified index.
     */
    public double getComponent(int index) {
        return components.get(index);
    }

    /**
     * Check if this vector is equal to another vector.
     * @param other The vector to compare against.
     * @return True if both vectors have the same dimension and corresponding components are equal.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof VectorB)) {
            return false;
        }
        VectorB otherVector = (VectorB) other;
        return dimension() == otherVector.dimension() &&
                components.equals(otherVector.components);
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @Override
    public String toString() {
        return components.toString();
    }

    /**
     * Add two vectors together component-wise.
     * @param other The vector to add to this vector.
     * @return A new vector that is the result of adding this vector and the other vector.
     * @throws IllegalArgumentException If the vectors have different dimensions.
     */
    public VectorB add(VectorB other) {
        if (dimension() != other.dimension()) {
            throw new IllegalArgumentException("Vectors must have the same dimension for addition.");
        }
        List<Double> resultComponents = new ArrayList<>();
        for (int i = 0; i < dimension(); i++) {
            resultComponents.add(getComponent(i) + other.getComponent(i));
        }
        return new VectorB(resultComponents);
    }

    /**
     * Multiply this vector by a scalar.
     * @param scalar The scalar to multiply the vector by.
     * @return A new vector that is the result of multiplying this vector by the scalar.
     */
    public Vector multiplyByScalar(double scalar) {
        List<Double> resultComponents = new ArrayList<>();
        for (double component : components) {
            resultComponents.add(component * scalar);
        }
        return new Vector(resultComponents);
    }

    /**
     * Calculate the magnitude (Euclidean norm) of this vector.
     * @return The magnitude of the vector.
     */
    public double magnitude() {
        double sum = 0;
        for (double component : components) {
            sum += component * component;
        }
        return Math.sqrt(sum);
    }
}