package E3_SwapIndexesString;

import java.util.ArrayList;
import java.util.List;

public class Swap<T> {
    private List<T> list;

    public Swap() {
        this.list = new ArrayList<>();
    }


    public void add(T item) {
        this.list.add(item);

    }

    public void makeASwap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= this.list.size() || index2 >= this.list.size()) {
            return;
        }
        T temp = this.list.get(index2);
        this.list.set(index2, this.list.get(index1));
        this.list.set(index1, temp);
    }

    @Override
    public String toString() {
        StringBuilder asd = new StringBuilder();
        for (T t : list) {
            asd.append(t.getClass().getName())
                    .append(": ").append(t)
                    .append(System.lineSeparator());
        }

        return asd.toString();
    }
}
