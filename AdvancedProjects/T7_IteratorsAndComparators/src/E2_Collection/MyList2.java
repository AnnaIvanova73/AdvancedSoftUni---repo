package E2_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyList2 <E> implements Iterable<E> {
    private List<E> list;
    private int index;

    @SafeVarargs
    public MyList2(E... elements) {
        this.setElements(elements);
        this.index = 0;
    }

    public boolean move() {
        boolean canItBeMoved = false;
        if(hasNext()){
            index ++;
            canItBeMoved = true;
        }
        return canItBeMoved;
    }


    public boolean hasNext() {
        return index >= 0 && index < list.size() - 1;
    }

    public void print () {
        if(list.size() != 0){
            System.out.println(list.get(index));
        }else{
            String message ="Invalid Operation!";
            throw new IndexOutOfBoundsException (message);
        }
    }

    @SafeVarargs
    private void setElements(E... elements) {
        this.list = Arrays.asList(elements);
    }

    @Override
    public String toString (){
        StringBuilder result = new StringBuilder();
        for (E e : list) {
            result.append(e).append(" ");
        }
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorForMyList2<E>(this.list,this.index);
    }
}
