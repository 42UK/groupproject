package src;

import src.algorithms.SortStrategy;
import src.fillable.FillStrategy;
import src.fillable.user.User;

import java.util.ArrayList;
import java.util.List;

public class CollectionManager<T extends Comparable<T>> {
    List<T> list = new ArrayList<>();
    Class<T> typeParameterClass;
    SortStrategy<T> sortStrategy;
    FillStrategy fillStrategy;

    public CollectionManager(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void setFillStrategy(FillStrategy.CollectionFillStrategy fillStrategy) {
        this.fillStrategy = FillStrategy.getFillStrategy(typeParameterClass, fillStrategy);
    }

    //КАК СДЕЛАТЬ ЭТО НОРМАЛЬНО БЕЗ RAW TYPE Я ЩАС С УМА СОЙДУ ЕЙ БОГУ
    public void fill(int cap) {
        try {
            this.list = fillStrategy.fill(cap);
        } catch (Exception e) { }
    }

    public void setSortStrategy(SortStrategy.CollectionSortStrategy sortStrategyEnum) {
        this.sortStrategy = SortStrategy.getSortStrategy(sortStrategyEnum);
    }

    public void sort() {
        if (Comparable.class.isAssignableFrom(typeParameterClass)) {

        }
        sortStrategy.sort(list);
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public static void main(String[] args) {
        CollectionManager<? extends Comparable<?>> cm = new CollectionManager<>(User.class);
        cm.setFillStrategy(FillStrategy.CollectionFillStrategy.CONSOLE);
        cm.fill(5);
        cm.setSortStrategy(SortStrategy.CollectionSortStrategy.QUICKSORT);
        cm.sort();
        for (var i : cm.getList()) {
            System.out.println(i);
        }
    }
    //    public void fill() {
//        fillStrategy.fill(list);
//    }
}
