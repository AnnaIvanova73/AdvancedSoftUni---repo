import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class E10_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String line;
        while (!(line = reader.readLine()).equals("Party!")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[1];

            BiPredicate<String, String> predicate = null;
            switch (command) {
                case "StartsWith":
                    predicate = String::startsWith;
                    break;
                case "EndsWith":
                    predicate = String::endsWith;
                    break;
                case "Length":
                    predicate = (n, l) -> {
                        int len = Integer.parseInt(l);
                        return n.length() == len;
                    };
                    break;
            }

            String removeOrDouble = tokens[0];
            if ("Double".equals(removeOrDouble)) {
                int size = names.size();
                for (int i = 0; i < size; i++) {
                    if (predicate.test(names.get(i), tokens[2])) {
                        names.add(names.get(i));
                    }
                }
            } else if ("Remove".equals(removeOrDouble)) {
                for (int i = 0; i < names.size(); i++) {
                    if (predicate.test(names.get(i), tokens[2])) {
                        names.remove(i);
                        i--;
                    }
                }
            }

        }

        Collections.sort(names);
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        System.out.print(String.join(", ", names));
        System.out.println(" are going to the party!");
    }
}
