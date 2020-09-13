package E5_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box(){
        this.data = new ArrayList<>();
    }

    public void addElement (T element){
        this.data.add(element);
    }

    public int getCountOfGreaterElements (T element){
        int count = 0;
        for (T datum : data) {
            int i = datum.compareTo(element);
            if(i > 0){
                count++;
            }
        }
       return count;
    }
}
