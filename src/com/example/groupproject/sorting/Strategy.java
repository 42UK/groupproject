package src.com.example.groupproject.sorting;


public interface Strategy<T> {
    void sort(T[] array);

    default int search (T[] array, T key) {
        return 0;
    }
}
