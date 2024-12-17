/*package Memory462121;
public class NewtonRaphsonMethod {
    private static double MAX_ITERATIONS = 100;
    private static double TOLERANCE = 0.0001;

    public static double newtonRaphson(double initialEstimate, DerivativeFunction derivativeFunction) {
        double xn = initialEstimate;

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            double fxn = derivativeFunction.function(xn);
            double fpxn = derivativeFunction.derivative(xn);

            if (Math.abs(fpxn) < TOLERANCE) {
                throw new RuntimeException("Derivative is too close to zero");
            }

            double xnPlusOne = xn - fxn / fpxn;

            if (Math.abs(xnPlusOne - xn) < TOLERANCE) {
                return xnPlusOne;
            }

            xn = xnPlusOne;
        }

        throw new RuntimeException("Method did not converge within the specified iterations");
    }

    @FunctionalInterface
    public interface DerivativeFunction {
        double function(double x);
        double derivative(double x);
    }

    public static void main(String[] args) {
        DerivativeFunction cubeFunction = x -> x * x * x;
        DerivativeFunction cubeDerivative = x -> 3 * x * x;

        double root = newtonRaphson(1.0, (x) -> {
            return new DerivativeFunction() {
                @Override
                public double function(double x) {
                    return cubeFunction.function(x) - 2;
                }

                @Override
                public double derivative(double x) {
                    return cubeDerivative.function(x);
                }
            };
        }().function(x));

        System.out.println("Approximated root of x^3 - 2: " + root);
    }
}*/