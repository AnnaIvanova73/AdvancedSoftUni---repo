package E4_GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap<T> {
    private List<T> data;

    public Swap() {
        this.data = new ArrayList<>();
    }

    public void add(T number) {
        this.data.add(number);
    }

    public void swapIndexes (int index,int index2){
        if(index < 0 || index2 < 0 || index >= this.data.size() || index2 >= this.data.size()){
            return;
        }
        Collections.swap(this.data,index2,index);
    }

    @Override
    public String toString (){
        StringBuilder perPrint = new StringBuilder();
        this.data.forEach(element -> {
            perPrint.append(element.getClass().getName()).append(": ")
                    .append(element).append(System.lineSeparator());
        });
        return perPrint.toString();
    }
}
