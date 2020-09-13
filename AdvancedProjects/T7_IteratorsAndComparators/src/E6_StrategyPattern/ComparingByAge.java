package E6_StrategyPattern;

import java.util.Comparator;

public class ComparingByAge implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
       return Integer.compare(first.getAge(),second.getAge());
    }
}
