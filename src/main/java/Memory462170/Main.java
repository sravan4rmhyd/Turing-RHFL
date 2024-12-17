package Memory462170;
/**
 * Represents a basic shape with methods to calculate area and perimeter.
 */
abstract class Shape {
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
 * An interface representing basic behaviors for shapes.
 */
interface Drawable {
    /**
     * Draws the shape.
     * 
     * @param canvas the canvas on which the shape will be drawn.
     */
    void draw(String canvas);
}

/**
 * Represents a Rectangle which is a type of Shape and is also Drawable.
 */
class Rectangle extends Shape implements Drawable {
    private double length;
    private double width;

    /**
     * Constructs a Rectangle with specified length and width.
     * 
     * @param length the length of the rectangle.
     * @param width the width of the rectangle.
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return the area of the rectangle as a double.
     */
    @Override
    public double area() {
        return length * width;
    }

    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle as a double.
     */
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    /**
     * Draws the rectangle on the specified canvas.
     *
     * @param canvas the canvas on which the rectangle will be drawn.
     */
    @Override
    public void draw(String canvas) {
        System.out.println("Drawing rectangle on " + canvas);
    }

    /**
     * Scales the rectangle by a specified factor.
     * 
     * @param factor the scale factor (must be greater than 0).
     * @return a new Rectangle object with scaled dimensions.
     * @throws IllegalArgumentException if the factor is less than or equal to 0.
     */
    public Rectangle scale(double factor) throws IllegalArgumentException {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be greater than 0.");
        }
        return new Rectangle(length * factor, width * factor);
    }
}

/**
 * Demonstration of using the Rectangle class.
 */
public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Area: " + rect.area());
        System.out.println("Perimeter: " + rect.perimeter());

        // Drawing the rectangle
        rect.draw("MyCanvas");

        try {
            Rectangle scaledRect = rect.scale(2);
            System.out.println("Scaled Area: " + scaledRect.area());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}