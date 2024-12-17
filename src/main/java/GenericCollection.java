import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A generic collection class that provides methods for manipulating a list of objects.
 *
 * @param <T> the type of elements in this collection
 */
public class GenericCollection<T> {
    private final List<T> items;

    public GenericCollection() {
        items = new ArrayList<T>();
    }

    /**
     * Adds an item to the collection.
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
     * Removes an item from the collection.
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
     * Returns the number of items in the collection.
     *
     * @return the size of the collection
     */
    public int size() {
        return items.size();
    }

    /**
     * Sorts the collection using the provided comparator.
     *
     * @param comparator the comparator to define the sort order
     */
    public void sort(Comparator<? super T> comparator) {
        Collections.sort(items, comparator);
    }

    /**
     * Searches for an item in the collection.
     *
     * @param item the item to search for
     * @return the index of the item if found, -1 otherwise
     */
    public int search(T item) {
        return items.indexOf(item);
    }
}