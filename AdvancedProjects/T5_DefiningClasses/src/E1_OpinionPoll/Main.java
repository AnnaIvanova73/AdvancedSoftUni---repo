package E1_OpinionPoll;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countLines = Integer.parseInt(scan.nextLine());

        Set<Person> personsData = new HashSet<>();
        while (countLines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personsData.add(person);
        }


        personsData.stream().filter(a -> a.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(p ->{
                    System.out.printf("%s - %s%n", p.getName(), p.getAge());
                });
    }
}
