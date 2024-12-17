package Memory462121;
public class NewtonRaphsonB {

    // Define the function for which we want to find the root
    public static double function(double x) {
        return x * x - 2;  // Example: f(x) = x^2 - 2
    }

    // Define the derivative of the function
    public static double derivative(double x) {
        return 2 * x;  // Example: f'(x) = 2x
    }

    // Implement the Newton-Raphson method
    public static double newtonRaphson(double initialGuess, double tolerance, int maxIterations) {
        double x = initialGuess;

        for (int i = 0; i < maxIterations; i++) {
            double functionValue = function(x);
            double derivativeValue = derivative(x);
            double xNext = x - functionValue / derivativeValue;

            // Check if the result is within the accepted tolerance
            if (Math.abs(xNext - x) < tolerance) {
                return xNext; // Return the root if it is within the tolerance
            }
            x = xNext; // Update x for the next iteration
        }

        // Return the last computed x if max iterations are reached
        return x;
    }

    public static void main(String[] args) {
        double initialGuess = 1.0;      // Starting point for the iteration
        double tolerance = 1e-7;         // Acceptable error tolerance
        int maxIterations = 1000;        // Maximum iterations to prevent infinite loops

        double root = newtonRaphson(initialGuess, tolerance, maxIterations);
        System.out.println("Root: " + root);
    }
}