import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class E6_PredicateforNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int compareNum = Integer.parseInt(reader.readLine());

        Predicate<String> compare = e -> e.length() <= compareNum;

        Arrays.stream(reader.readLine().split("\\s+")).map(String::toString).filter(compare).forEach(System.out::println);

    }
}
