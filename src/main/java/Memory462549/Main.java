package Memory462549;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class InventoryManager {
    public List<Product> calculateTotalPrice(List<Product> products) {
        return products.stream()
                .filter(product -> product.price > 10)
                .mapToDouble(Product::getPrice)
                .sum() > 100 ?
                products :
                new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Phone", 500.0),
                new Product("Laptop", 1200.0),
                new Product("Book", 10.0),
                new Product("Pen", 5.0)
        );

        InventoryManager inventoryManager = new InventoryManager();
        List<Product> filteredProducts = inventoryManager.calculateTotalPrice(products);

        filteredProducts.forEach(System.out::println);
    }
}

extension Product {
    double getPrice() {
        return price;
    }
}