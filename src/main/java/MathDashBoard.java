/*import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MathDashBoard {

    public static <T extends Number> MathDashBoard<T> createDashboard(List<T> numbers) {
        return new MathDashBoard<>(numbers);
    }

    private final List<Double> numbers;

    private MathDashBoard(List<Double> numbers) {
        this.numbers = numbers == null ? new ArrayList<>() : numbers;
    }

    // Display the dashboard
    public void displayDashboard() {
        System.out.println("Mathematical Dashboard:");
        System.out.println("------------------------");
        System.out.println("Count: " + count());
        System.out.println("Average: " + average());
        System.out.println("Sum: " + sum());
        System.out.println("Min: " + min());
        System.out.println("Max: " + max());
        System.out.println("Median: " + median());
    }

    
    private int count() {
        return numbers.stream().mapToInt(num -> 1).sum();
    }

    private double average() {
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        return count() == 0 ? 0.0 : sum / count();
    }

    private double sum() {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    private double min() {
        return numbers.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    private double max() {
        return numbers.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    private double median() {
        int size = count();
        numbers.stream().sorted().mapToDouble(Double::doubleValue);

        if (size == 0) {
            return 0.0;
        }

        if (size % 2 == 0) {
            int midIndex1 = size / 2 - 1;
            int midIndex2 = size / 2;
            return (numbers.get(midIndex1).doubleValue() + numbers.get(midIndex2).doubleValue()) / 2;
        } else {
            int midIndex = size / 2;
            return numbers.get(midIndex).doubleValue();
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Double> data = List.of(1.0, 8.9, 4.5, 3.2, 7.0, 9.8, 2.3, 5.6);
            MathDashBoard<Double> dashboard = MathDashBoard.createDashboard(data);
        dashboard.displayDashboard();
    }
}*/