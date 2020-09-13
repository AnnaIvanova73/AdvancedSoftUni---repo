package CustomSmartArrayMartin;

import java.util.function.Consumer;

public class SmartArray {


    private int[] elements;
    private int index;

    public SmartArray() {
        this.elements = new int[8];
        this.index = 0;
    }

    public void add(int element) {
        if (this.elements.length == this.index) {
            this.elements = grow();
        }
        this.elements[index] = element;
        index++;
    }

    private int[] grow() {
        int[] newElements = new int[this.elements.length * 2];
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }
        return newElements;
    }

    public int get(int index) {
        ensureIndex(index);
        return this.elements[index];
    }

    private void ensureIndex(int index) {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException("SmartArray out of bounds for "
                    + "index " + index + " with legth " + this.size());
        }
    }

    public int size() {
        return this.index; // index a сочи към първата празна клетка, която не сме попълнилили, това което не можем да вземем
    }

    public int remove(int index) {
        int element = get(index);

        for (int i = index; i < this.size(); i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.size()] = 0;

        this.index--;

        if (this.size() <= this.elements.length / 4) {
            this.elements = shrink();
        }
        return element;
    }

    private int[] shrink() {
        int[] newElements = new int[this.elements.length / 2];
        if (this.size() >= 0) {
            System.arraycopy(this.elements, 0, newElements, 0, this.size());
        } else if (this.size() == 0) {
            this.elements = new int[8];
        }
        return newElements;
    }


    public boolean isEmty() {
        return this.size() == 0;
    }

    public boolean contains(int element) {
        return this.indexOf(element) != 1;
    }

    public int indexOf(int element) {
        for (int i = 0; i < this.size(); i++) {
            if (element == this.elements[i]) {
                return i;
            }
        }
        return -1;

    }

    public void add(int index, int element){
        int last = get(this.size() -1);

        for (int i = this.size() - 1; i > index ; i--) {
            this.elements[index] = this.elements[i - 1];
            
        }
        this.elements[index] = element;
        this.add(last);
    }


    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size(); i++) {
            consumer.accept(this.elements[i]);
        }
    }
}
