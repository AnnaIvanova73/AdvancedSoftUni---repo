package E8_CustomListSort;

import java.util.*;
import java.util.stream.IntStream;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public CustomList() {
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

    public  E getMax () {

        E max = this.getAt(0);
        for (int i = 0; i < this.size; i++) {
            if (this.getAt(i).compareTo(max) > 0) {
                max = this.getAt(i);
            }
        }
        return max;
    }

    public int getCountGreater(E element) {
        return (int) IntStream.range(0, this.size)
                .mapToObj(this::getAt)
                .filter(current -> current.compareTo(element) > 0)
                .count();
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
        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size - 1 - index);
            this.elements[this.size - 1] = null;
            this.size--;
        }
    }

    public void addElement(E element) {
        if (this.size == this.elements.length) {
            this.elements = resizeMyList();
        }
        this.elements[this.size++] = element;
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


    public int sizeObj() {
        return this.size;
    }

    public void sort() {
        Sorter<E> sorter = new Sorter<>();
        Sorter.sort(this);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return getElement(index++);
            }
        };
    }
}
