package E5_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();
        String line;
        while (!(line = reader.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            persons.add(person);
        }

        int personPerComparing = Integer.parseInt(reader.readLine());
        String perPrint = "No matches";
        try {
            Person person = persons.get(personPerComparing);

            int equal = 0;
            for (Person person1 : persons) {
                assert person != null;
                if (person.compareTo(person1) == 0) {
                    equal += 1;
                }
            }
            int totalPeople = persons.size();

            if (equal != 0) {
                System.out.println(perPrint = equal + " " + (totalPeople -= equal) + " " + persons.size());
            }

        } catch (IndexOutOfBoundsException E) {
            System.out.println(perPrint);
        }


    }
}
