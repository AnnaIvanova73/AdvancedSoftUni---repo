package E6_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfPersons = Integer.parseInt(reader.readLine());

        Set<Person> collectSortedByNames = new TreeSet<>(new ComparingByName());
        Set<Person> collectSortedByAge = new TreeSet<>(new ComparingByAge());

        for (int i = 0; i < countOfPersons; i++) {
            String[] tokens = reader.readLine().split("\\s+");


            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]));

            collectSortedByNames.add(person);
            collectSortedByAge.add(person);

        }

        for (Person person : collectSortedByNames) {
            System.out.println(person.toString());
        }
        for (Person person : collectSortedByAge) {
            System.out.println(person.toString());
        }
    }
}
