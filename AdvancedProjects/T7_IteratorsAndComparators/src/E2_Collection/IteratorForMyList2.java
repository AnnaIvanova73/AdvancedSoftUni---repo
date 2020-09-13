package E2_Collection;

import java.util.Iterator;
import java.util.List;

public class IteratorForMyList2 <E> implements Iterator<E> {

    private List<E> currentList;
    private int index;

    public IteratorForMyList2(List<E> list, int index) {
        this.currentList = list;
        this.index = index;
    }

    @Override
    public boolean hasNext() {
        return index < this.currentList.size();
    }

    @Override
    public E next() {
        return this.currentList.get(index);
    }
}
