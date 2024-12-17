/*import java.util.Arrays;

public class ArrayStack<E> {

    private final E[] elements;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        elements = (E[]) new Object[initialCapacity];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    // Push an element onto the top of the stack
    public void push(E element) {
        if (size == elements.length) {
            // Resize the array when capacity is reached
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = element;
        size++;
    }

    // Remove and return the top element from the stack
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        @SuppressWarnings("unchecked")
        E result = (E) elements[size];
        elements[size] = null;

        // If the stack is less than 25% full, resize the array
        if (size < elements.length / 4) {
            elements = Arrays.copyOf(elements, size * 2);
        }

        return result;
    }

    // Return the top element of the stack without removing it
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[size - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
    }


    public void clear() {
        size = 0;
        elements = Arrays.copyOf(elements, DEFAULT_CAPACITY); // Resize to default on clear
    }
}*/