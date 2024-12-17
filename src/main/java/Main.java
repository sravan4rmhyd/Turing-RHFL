import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Create a GenericCollection for Integer type
        GenericCollection<Integer> intCollection = new GenericCollection<Integer>();

        // Adding items
        intCollection.addItem(5);
        intCollection.addItem(2);
        intCollection.addItem(8);
        intCollection.addItem(1);

        // Size of the collection
        System.out.println("Size of collection: " + intCollection.size()); // Output: 4

        // Sorting the collection
        intCollection.sort(Comparator.naturalOrder());
        System.out.println("Sorted collection:");
        for (int i = 0; i < intCollection.size(); i++) {
            System.out.print(intCollection.getItem(i) + " "); // Output: 1 2 5 8
        }
        System.out.println();

        // Searching for an item
        int searchItem = 5;
        int index = intCollection.search(searchItem);
        if (index >= 0) {
            System.out.println("Item " + searchItem + " found at index: " + index);
        } else {
            System.out.println("Item " + searchItem + " not found.");
        }

        // Removing an item
        intCollection.removeItem(2);
        System.out.println("Size after removal: " + intCollection.size()); // Output: 3
    }
}