package CustomSmartArray;

import java.util.function.Consumer;

public class SmartArray {
    // --> static int[] elements --> фиксиран размер
    // --> class Node () -> int element
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;


    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }


    public void add(int element) {
       if(isNeedResizing()){
           this.resize();
       }

        this.data[this.size++] = element;
    }

    private boolean isNeedResizing() {
        return size == this.capacity;
    }


    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }


    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index >= this.data.length || index < 0) {
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int remove (int index){
        checkIndex(index);

        int valueToReturn = this.data[index];
        shift(index);
        this.size--;

        if(this.size <= this.capacity / 4){
            shrink();
        }

        return valueToReturn;
    }

    private void shift(int index) {
        for (int i = index; i < this.size -1 ; i++) {
                this.data[i] = this.data[i + 1];
        }

        this.data [size - 1] = 0;
    }

    private void shrink (){
        this.capacity /= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }

        this.data = copy;
    }


    public void add (int index, int element){
        checkIndex(index);

      if(index == this.size - 1){
          add (this.data [this.size -1]);
          this.data[this.size -2] = element;
      }else{
          this.size++;
          shiftRight(index);
          this.data[index] = element;
      }
    }

    private void shiftRight(int index){
        for (int i = this.size - 1; i > index ; i--) {
            this.data[i] = this.data[i-1];
        }
    }

    public boolean contains (int element){
        boolean isFound = false;

        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element){
                isFound = true;
                break;
            }
        }

        return isFound;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
