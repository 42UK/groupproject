package src.algorithms;


import java.util.List;

public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list) {
        quicksort(list, 0, list.size() - 1);
    }

    public void quicksort(List<T> list, int l, int r) {
        if (l < r) {
            int q = partition(list, l, r);
            quicksort(list, l, q);
            quicksort(list, q + 1, r);
        }
    }

    int partition(List<T> list, int l, int r) {
        T v = list.get((l + r) / 2);
        int i = l;
        int j = r;
        while (i <= j) {
            while (list.get(i).compareTo(v) < 0)
                i++;
            while (list.get(j).compareTo(v) > 0)
                j--;
            if (i >= j)
                break;
            T temp = list.get(i);
            list.set(i++, list.get(j));
            list.set(j--, temp);
        }
        return j;
    }
}
