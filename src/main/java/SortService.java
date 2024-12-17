public class SortService {
    private final MergeSort mergeSort;

    // Constructor injection for better testability
    public SortService(MergeSort mergeSort) {
        this.mergeSort = mergeSort;
    }

    // Method to sort an array of integers
    public int[] sort(int[] array) {
        return mergeSort.sort(array);
    }
}