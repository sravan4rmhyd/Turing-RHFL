package Memory462170;
/**
 * Represents a general geometric shape.
 */
abstract class GeometricShape {
    /**
     * Calculates the area of the shape.
     *
     * @return the area of the shape as a double.
     */
    public abstract double area();

    /**
     * Calculates the perimeter of the shape.
     *
     * @return the perimeter of the shape as a double.
     */
    public abstract double perimeter();
}

/**
 * An interface that defines a drawable behavior for shapes.
 */
interface Drawable2 {
    /**
     * Draws the shape on a specified surface.
     *
     * @param surface the name of the surface where the shape will be drawn.
     */
    void draw(String surface);
}

/**
 * Represents a Circle, which is a type of GeometricShape and implements Drawable.
 */
class Circle extends GeometricShape implements Drawable2 {
    private double radius;

    /**
     * Constructs a Circle with the specified radius.
     *
     * @param radius the radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return the area of the circle as a double.
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the perimeter (circumference) of the circle.
     *
     * @return the perimeter of the circle as a double.
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Draws the circle on the specified surface.
     *
     * @param surface the name of the surface where the circle will be drawn.
     */
    @Override
    public void draw(String surface) {
        System.out.println("Drawing a circle with radius " + radius + " on " + surface);
    }

    /**
     * Scales the circle's radius by a specified factor.
     *
     * @param factor the factor by which to scale the radius. Must be greater than 0.
     * @return a new Circle object with the scaled radius.
     * @throws IllegalArgumentException if the factor is less than or equal to 0.
     */
    public Circle scale(double factor) throws IllegalArgumentException {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be greater than 0.");
        }
        return new Circle(radius * factor);
    }
}

/**
 * Demonstrates the use of the Circle class.
 */
public class Main2 {
    public static void main(String[] args) {
        // Create a new Circle object with a radius of 5
        Circle circle = new Circle(5);

        // Display the area and perimeter of the circle
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        // Draw the circle on a surface
        circle.draw("Canvas");

        try {
            // Scale the circle by a factor of 2
            Circle scaledCircle = circle.scale(2);
            System.out.println("Scaled Circle Area: " + scaledCircle.area());
            System.out.println("Scaled Circle Perimeter: " + scaledCircle.perimeter());
        } catch (IllegalArgumentException e) {
            // Handle the exception if scaling factor is invalid
            System.err.println("Error: " + e.getMessage());
        }

        try {
            // Attempt to scale the circle with an invalid factor
            Circle invalidCircle = circle.scale(0); // This will throw an exception
        } catch (IllegalArgumentException e) {
            // Catch and print the exception message
            System.err.println("Error: " + e.getMessage());
        }
    }
}