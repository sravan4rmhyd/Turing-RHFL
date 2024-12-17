package refactor462120;
public class OrderB {
    private double subtotal;
    private double discount;
    private double taxRate;

    // Constructor remains the same
    public OrderB(double subtotal, double discount, double taxRate) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.taxRate = taxRate;
    }

    // Refactored calculateTotal method
    public double calculateTotal() {
        double totalBeforeTax = calculateTotalBeforeTax();
        return totalBeforeTax + calculateTax(totalBeforeTax);
    }

    // Calculates the total before tax, ensuring the total is at least 0
    private double calculateTotalBeforeTax() {
        double total = subtotal - discount;
        return Math.max(total, 0);
    }

    // Calculates the tax amount based on the total before tax
    private double calculateTax(double total) {
        return total * taxRate;
    }

    /**
     * Main method to test the refactored Order class
     */
    public static void main(String[] args) {
        // Simple test case to validate the refactored code
        double subtotal = 100.00;
        double discount = 20.00;
        double taxRate = 0.2;

        OrderB order = new OrderB(subtotal, discount, taxRate);
        double total = order.calculateTotal();

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Tax Rate: " + taxRate * 100 + "%");
        System.out.println("Total: $" + total);
    } 
}