/*public class GenericCollectionManagerExample {
    public static void main(String[] args) {
        GenericCollectionManager<Integer> integerManager = new GenericCollectionManager<Integer>();

        integerManager.addItem(8);
        integerManager.addItem(3);
        integerManager.addItem(2);
        integerManager.addItem(5);
        integerManager.addItem(4);
        integerManager.addItem(7);
        integerManager.addItem(6);
        integerManager.addItem(1);

        integerManager.sortItems();

        System.out.println("Sorted Integers: " + integerManager);

        int searchIndex = integerManager.binarySearch(5);
        if (searchIndex != -1) {
            System.out.println("Found 5 at index: " + searchIndex);
        } else {
            System.out.println("5 not found");
        }

        System.out.println("Largest integer: " + integerManager.findLargest().orElse("Empty"));
        System.out.println("Smallest integer: " + integerManager.findSmallest().orElse("Empty"));

        // Try using a different Comparable type (Strings)
        GenericCollectionManager<String> stringManager = new GenericCollectionManager<String>();
        stringManager.addItem("e");
        stringManager.addItem("a");
        stringManager.addItem("i");
        stringManager.addItem("o");
        stringManager.addItem("u");

        stringManager.sortItems();
        System.out.println("Sorted Strings: " + stringManager);
    }
}*/