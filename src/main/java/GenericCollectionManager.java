/*import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCollectionManager<T extends Comparable<? super T>> {
    private final List<T> items;

    public GenericCollectionManager() {
        items = new ArrayList<T>();
    }

    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public boolean containsItem(T item) {
        return items.contains(item);
    }


    public void sortItems() {
        items.sort(null); // Natural ordering
    }

    public int binarySearch(T key) {
        return items.stream()
                .mapToInt(List::indexOf)
                .filter(i -> items.get(i).equals(key))
                .findFirst()
                .orElse(-1);
    }

    public Optional<T> findLargest() {
        return items.stream().max(Comparator.naturalOrder());
    }
    public Optional<T> findSmallest() {
        return items.stream().min(Comparator.naturalOrder());
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "GenericCollectionManager{" +
                "items=" + items +
                '}';
    }
}*/