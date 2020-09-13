package CustomStackClass;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyStack {
    private static final int INITIAL_CAPACITY  = 4;
    private int capacity;
    private int size;
    private int[] items;

    public MyStack(){
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
    }

    public int getSize (){
        return this.size;
    }
    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.items.length; i++) {
            copy[i] = this.items[i];
        }
        this.items = copy;
    }

    public void push (int element){
        if(this.size == this.capacity){
            this.resize();
        }
        this.items[this.size ++] = element;
    }

    public int pop (){
            int element = this.items[this.size -1];
            this.size --;
            return element;
    }

    public Integer peek (){
        Integer element = null;
        if(this.size != 0){
            element = this.items[this.size -1];
        }
        return element;
    }

    private void checkEmpty(){
        if(this.size == 0){
            throw new NoSuchElementException("CustomStackIsEmpty");
        }
    }

    public void forEach (Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }
}
