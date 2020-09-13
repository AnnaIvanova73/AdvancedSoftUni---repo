package E3_StackIterator;

import java.util.Iterator;

public class SecondStack implements Iterable<Integer> {
    private int[] elements;
    private int size;


    public void pop (){
        if(elements.length == 0){
            System.out.println("No elements");
        }else{
            int[] temp = new int[size - 1];

            System.arraycopy(this.elements, 0, temp, 0, temp.length);
            this.elements = temp;

            size--;
        }
    }

    public void push (int... elements){

        if(size == 0){
            this.elements = new int[elements.length];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            size += elements.length;
            return;
        }
        this.size += elements.length;
        int[] temp = new int[size];

        System.arraycopy(this.elements, 0, temp, 0, this.elements.length);

        System.arraycopy(elements, 0, temp, this.elements.length, elements.length);

        this.elements = temp;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return elements[index--];
            }
        };
    }

    @Override
    public String toString (){
        StringBuilder result = new StringBuilder();

        for (int i = this.elements.length - 1 ; i >= 0 ; i--) {
            result.append(this.elements[i]).append(System.lineSeparator());
        }
        return result.toString();
    }
}
