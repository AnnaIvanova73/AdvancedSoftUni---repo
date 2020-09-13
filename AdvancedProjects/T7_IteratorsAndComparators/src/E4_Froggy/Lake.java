package E4_Froggy;

import java.util.*;

public class Lake implements Iterable<Integer> {
    private List<Integer> lake;
    private int index ;

    public Lake() {
        this.setStones();
        this.index = 0;
    }

    public void setStones(Integer... args) {
        this.lake = Arrays.asList(args);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FrogJumps();
    }

    private  class FrogJumps implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return index  < lake.size();
        }

        @Override
        public Integer next() {
            int stone = lake.get(index);
            index += 2;

            if (index >= lake.size() && index % 2 == 0) {
                index = 1;
            }

            return stone;
        }
    }
}
