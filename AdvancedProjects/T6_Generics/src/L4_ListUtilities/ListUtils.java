package L4_ListUtilities;

import java.util.List;

public class ListUtils {


    public static <T extends Comparable<T>> T getMax(List<T> list) {

        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }

        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        if (elements.size() == 0) {
            throw new IllegalArgumentException();
        }

        T min = elements.get(0);
        for (T element : elements) {
                if(min.compareTo(element) > 0){
                    min = element;
                }
        }

        return min;
    }


}
