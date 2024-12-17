package Memory462121;
public class NewtonRaphson {

    // Function for which we want to find the root
    public static double f(double x) {
        return x * x - 2;  // Example: f(x) = x^2 - 2
    }

    // Derivative of the function
    public static double df(double x) {
        return 2 * x;  // Example: f'(x) = 2x
    }

    // Newton-Raphson method
    public static double newtonRaphson(double initialGuess, double tolerance, int maxIterations) {
        double x = initialGuess;
        for (int i = 0; i < maxIterations; i++) {
            double xNext = x - f(x) / df(x);
            if (Math.abs(xNext - x) < tolerance) {
                return xNext; // Return root if within tolerance
            }
            x = xNext;
        }
        return x; // Return the last computed x after max iterations
    }

    public static void main(String[] args) {
        double initialGuess = 1.0;
        double tolerance = 1e-7;
        int maxIterations = 1000;

        double root = newtonRaphson(initialGuess, tolerance, maxIterations);
        System.out.println("Root: " + root);
    }
}