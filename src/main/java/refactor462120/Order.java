package refactor462120;

public class Order {
    // Private instance variables to store the subtotal, discount, and tax rate
    private double subtotal;
    private double discount;
    private double taxRate;

    // Constructor to initialize the Order object
    public Order(double subtotal, double discount, double taxRate) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.taxRate = taxRate;
    }

    // Public method to calculate the total price of the order
    public double calculateTotal() {
        // Calculate the total before tax
        double totalBeforeTax = calculateTotalBeforeTax();
        // Add tax to the total before tax and return the final total
        return totalBeforeTax + calculateTax(totalBeforeTax);
    }

    // Private method to calculate the total before tax
    private double calculateTotalBeforeTax() {
        // Calculate total after applying discount
        double total = subtotal - discount;
        // Ensure that the total is not negative
        return Math.max(total, 0); // Using Math.max to enforce non-negative total
    }

    // Private method to calculate the tax based on the total
    private double calculateTax(double total) {
        // Calculate the tax based on the provided tax rate
        return total * taxRate;
    }

    // Main method to test the refactored Order class
    public static void main(String[] args) {
        // Test case: Creating an Order with a subtotal of 100, a discount of 20, and a tax rate of 0.1 (10%)
        Order order = new Order(100, 20, 0.1);

        // Calculate the total for the order
        double totalAmount = order.calculateTotal();

        // Print the total amount to the console
        System.out.println("Total amount for the order: $" + totalAmount);

        // Additional test case: Creating an Order with no discounts and a different tax rate
        Order order2 = new Order(150, 0, 0.2); // 0 discount, 20% tax
        double totalAmount2 = order2.calculateTotal();
        System.out.println("Total amount for the second order: $" + totalAmount2);
    }
}