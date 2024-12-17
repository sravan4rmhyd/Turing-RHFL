public class OrderProcessor {

    public void processOrder(Order order) {
        OrderValidationStatus status = validateOrder(order);
        if (status == OrderValidationStatus.VALID) {
            shipOrder(order);
        } else {
            System.out.println("Order processing failed: " + status);
        }
    }

    private OrderValidationStatus validateOrder(Order order) {
        if (order.getOrderId() <= 0 || order.getOrderTotal() <= 0 || order.getCustomerName().trim().isEmpty()) {
            return OrderValidationStatus.INVALID_DATA;
        }
        return OrderValidationStatus.VALID;
    }

    private void shipOrder(Order order) {
        System.out.println("Order " + order.getOrderId() + " shipped to: " + order.getCustomerName() + ", " + order.getShippingAddress());
    }

    public static void main(String[] args) {
        new OrderProcessor().processOrder(
                new Order(123, 100.0, "Bob", "Street Name")
        );
    }

    private static class Order {
        private final int orderId;
        private final double orderTotal;
        private final String customerName;
        private final String shippingAddress;

        public Order(int orderId, double orderTotal, String customerName, String shippingAddress) {
            this.orderId = orderId;
            this.orderTotal = orderTotal;
            this.customerName = customerName;
            this.shippingAddress = shippingAddress;
        }

        public int getOrderId() {
            return orderId;
        }

        public double getOrderTotal() {
            return orderTotal;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }
    }

    enum OrderValidationStatus {
        VALID, INVALID_DATA
    }
}