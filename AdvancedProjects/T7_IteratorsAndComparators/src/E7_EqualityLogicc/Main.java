package E7_EqualityLogicc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countInput = Integer.parseInt(reader.readLine());

        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();

        for (int i = 0; i < countInput; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]));
            treeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());

    }
}
