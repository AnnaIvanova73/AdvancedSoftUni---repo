package E3_StackIterator;


import java.util.Iterator;
import java.util.LinkedList;

public class FirstStack implements Iterable<Integer> {
    private LinkedList<Integer> myStack;

    public FirstStack() {
        myStack = new LinkedList<>();
    }

    public void push(Integer... elements) {
        for (Integer element : elements) {
            myStack.addFirst(element);
        }
    }

    public void pop (){
        if(myStack.isEmpty()){
            System.out.println("No elements");
            return;
        }
        myStack.removeFirst();
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int currentInd = 0;
            @Override
            public boolean hasNext() {

                return currentInd < myStack.size() ;
            }

            @Override
            public Integer next() {
                return myStack.get(currentInd ++);
            }
        };
    }

    @Override
    public String toString (){
        StringBuilder result = new StringBuilder();

        for (Integer integer : myStack) {
            result.append(integer).append(System.lineSeparator());
        }
        return result.toString();
    }
}
