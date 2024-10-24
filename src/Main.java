package src;

import src.algorithms.InsertionSort;
import src.algorithms.SortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(5, 8, 11, 1, -2, -5));
        SortStrategy<Integer> sortInt = new InsertionSort<>();
        sortInt.sort(a);
        for (Integer i : a) {
            System.out.printf(i + " ");
        }

        List<A> as = new ArrayList<>(List.of(new A("a"), new A("z"), new A("x"), new A("b")));
        SortStrategy<A> sortAs = new InsertionSort<>();
        sortAs.sort(as);

        for (A i : as) {
            System.out.printf(i + " ");
        }

        a.sort(null);
    }

    static class A implements Comparable<A> {
        String a;

        public A(String a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a1 = (A) o;
            return Objects.equals(a, a1.a);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(a);
        }

        @Override
        public int compareTo(A o) {
            return a.compareTo(o.a);
        }

        @Override
        public String toString() {
            return "A{" +
                    "a='" + a + '\'' +
                    '}';
        }
    }
}