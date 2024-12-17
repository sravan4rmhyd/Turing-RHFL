/*package Memory462121;
public class NewtonRaphson2 {
    private static final double TOLERANCE = 1e-7;
    private static final int MAX_ITERATIONS = 1000;

    public static double newtonRaphson(double initialGuess, double f(double x), double df(double x) ){
        double x = initialGuess;
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            double xNext = x - f(x) / df(x);
            if (Math.abs(xNext - x) < TOLERANCE) {
                return xNext;
            }
            x = xNext;
        }
        return x;
    }

    public static void main(String[] args) {
        double root = newtonRaphson(1.0, x -> x * x - 2, x -> 2 * x);
        System.out.println("Root of x^2 - 2: " + root);
    }
}*/