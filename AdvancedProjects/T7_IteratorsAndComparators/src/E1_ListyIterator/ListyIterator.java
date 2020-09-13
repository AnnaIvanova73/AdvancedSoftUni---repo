package E1_ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator<E> {
    private List<E> list;
    private int internalIndex;

    public ListyIterator (E[] data){
        this.list = new ArrayList<>(List.of(data));
        this.internalIndex = 0;
    }

    public boolean moveIndex (){
        if (checkMovement()){
           this.internalIndex ++;
            return true;
        }
        return false;
    }
    public E getElement (){
        if(this.list.size() == 0){
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        return this.list.get(this.internalIndex);
    }


    public boolean hasNext (){
        return checkMovement();
    }


    private boolean checkMovement() {
        return this.internalIndex >=0 && this.internalIndex < list.size() - 1;
    }

}
