package E8_CustomListSort;

public class Sorter<E extends Comparable<E>> extends CustomList<E> {

    public static <E extends Comparable<E>> void sort(CustomList<E> list) {
        int n = list.sizeObj();
        for (int i = 0; i < n; i++) {
            E element = list.getElement(i);
            for (int j = 0; j < n; j++) {
                if (element.compareTo(list.getElement(j)) < 0) {
                    list.swapIndexes(j, i);
                }
            }
        }
    }
}
