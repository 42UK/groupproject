package src.algorithms;


import java.util.List;

public interface SortStrategy<T extends Comparable<T>> {
    void sort(List<T> list);

    static <T extends Comparable<T>> SortStrategy<T> getSortStrategy(CollectionSortStrategy sortStrategyEnum) {
        switch (sortStrategyEnum) {
            case INSERTION -> {
                return new InsertionSort<>();
            }
            case QUICKSORT -> {
                return new QuickSort<>();
            }
        }
        return new QuickSort<>();
    }

    enum CollectionSortStrategy {
        QUICKSORT, INSERTION;
    }
}
