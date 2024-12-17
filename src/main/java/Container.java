import java.util.ArrayList;
import java.util.List;

/**
 * A generic container class that can hold objects of any type.
 *
 * @param <T> the type of elements in this container
 */
public class Container<T> {
    private final List<T> items;

    public Container() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the container.
     *
     * @param item the item to add
     */
    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    /**
     * Removes an item from the container.
     *
     * @param item the item to remove
     * @return true if the item was removed, false otherwise
     */
    public boolean removeItem(T item) {
        return items.remove(item);
    }

    /**
     * Retrieves an item by its index.
     *
     * @param index the index of the item to retrieve
     * @return the item at the specified index
     */
    public T getItem(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + items.size());
        }
        return items.get(index);
    }

    /**
     * Returns the number of items in the container.
     *
     * @return the size of the container
     */
    public int size() {
        return items.size();
    }
}