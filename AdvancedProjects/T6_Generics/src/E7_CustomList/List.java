package E7_CustomList;
import java.util.Arrays;
import java.util.Objects;

public class List<E extends Comparable<E> > {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public List() {
        this.elements = new Object[INITIAL_CAPACITY];
    }

    public E getMin() {
        E min = this.getAt(0);
        for (int i = 0; i < this.size; i++) {
            if (this.getAt(i).compareTo(min) < 0) {
                min = this.getAt(i);
            }
        }
        return min;
    }
    public E getMax() {
        E max = this.getAt(0);
        for (int i = 0; i < this.size; i++) {
            if (this.getAt(i).compareTo(max) > 0) {
                max = this.getAt(i);
            }
        }
        return max;
    }

    public int getCountGreater(E element) {
        int counter = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.getAt(i).compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public void swapIndexes(int i1, int i2) {
        checkIndex(i1);
        checkIndex(i2);
        E temp = this.getElement(i1);
        this.elements[i1] = this.elements[i2];
        this.elements[i2] = temp;
    }

    public boolean containsElement(E element) {
        return Arrays.stream(this.elements).filter(Objects::nonNull).anyMatch(a -> a.equals(element));
    }

    public void removeElement(int index) {
        checkIndex(index);
        if (this.size - 1 - index >= 0) {// ----> 5-1-4 okey ot index 4, 5-1-5 = -1, няма индекс
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
            this.elements[this.size - 1] = null;
            this.size--;
        }
    }

    public void addElement(E element) {
        if (this.size == this.elements.length) {
            this.elements = resizeMyList();
        }
        this.elements[this.size++] = element;// поставя на нула сочи към едно, постинкрементацията
    }

    public E getElement(int index) {
        checkIndex(index);
        return this.getAt(index);
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        }
    }

    private Object[] resizeMyList() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    public void printList() {
        Arrays.stream(this.elements).filter(Objects::nonNull).forEach(System.out::println);
    }
}
