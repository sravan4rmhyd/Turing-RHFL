public class Main {
    public static void main(String[] args) {
        // Create a container for String type
        Container<String> stringContainer = new Container<String>();

        // Adding items
        stringContainer.addItem("Hello");
        stringContainer.addItem("World");

        // Accessing items
        System.out.println("Item at index 0: " + stringContainer.getItem(0)); // Output: Hello
        System.out.println("Size of container: " + stringContainer.size()); // Output: 2

        // Create a container for Integer type
        Container<Integer> integerContainer = new Container<Integer>();

        // Adding items
        integerContainer.addItem(10);
        integerContainer.addItem(20);

        // Accessing items
        System.out.println("Item at index 0: " + integerContainer.getItem(0)); // Output: 10
        System.out.println("Size of container: " + integerContainer.size()); // Output: 2

        // Removing an item
        integerContainer.removeItem(10);
        System.out.println("Size after removal: " + integerContainer.size()); // Output: 1
    }
}