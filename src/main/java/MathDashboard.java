import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MathDashboard<T extends Number> {

    // Method to calculate the average of a list of numbers
    public double calculateAverage(List<T> numbers) {
        return numbers.stream()
                      .mapToDouble(Number::doubleValue)
                      .average()
                      .orElse(0.0);
    }

    // Method to find maximum value in a list
    public T findMax(List<T> numbers) {
        return numbers.stream()
                      .max(Comparator.comparingDouble(Number::doubleValue))
                      .orElse(null); // returns null if the list is empty
    }

    // Method to group numbers by their integer value
    public Map<Integer, List<T>> groupByIntegerValue(List<T> numbers) {
        return numbers.stream()
                      .collect(Collectors.groupingBy(number -> number.intValue()));
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Creating a list of Double numbers
        List<Double> numbers = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5, 2.5, 1.5);

        // Creating instance of MathDashboard for Double type
        MathDashboard<Double> dashboard = new MathDashboard<>();

        // Calculate average
        double average = dashboard.calculateAverage(numbers);
        System.out.println("Average: " + average);

        // Find maximum value
        Double max = dashboard.findMax(numbers);
        System.out.println("Max: " + max);

        // Group by integer value
        Map<Integer, List<Double>> groupedNumbers = dashboard.groupByIntegerValue(numbers);
        System.out.println("Grouped by Integer Value: " + groupedNumbers);
    }
}