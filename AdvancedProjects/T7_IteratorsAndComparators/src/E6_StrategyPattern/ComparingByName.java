package E6_StrategyPattern;

import java.util.Comparator;

public class ComparingByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int compare = Comparator.comparing(Person::getNameLength).compare(first, second);
        if (compare == 0) {
            compare = compareByFirstLetter(first,second);
        }
        return compare;
    }


    public int compareByFirstLetter (Person first, Person second) {
        if (first.getName().toUpperCase().charAt(0) == second.getName().toUpperCase().charAt(0)) {
            return 0;
        } else if (first.getName().toUpperCase().charAt(0) > second.getName().toUpperCase().charAt(0)) {
            return 1;
        }
        return -1;
    }
}