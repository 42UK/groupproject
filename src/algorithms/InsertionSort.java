package src.algorithms;


import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            T currentElement = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(currentElement) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, currentElement);
        }
    }
}
