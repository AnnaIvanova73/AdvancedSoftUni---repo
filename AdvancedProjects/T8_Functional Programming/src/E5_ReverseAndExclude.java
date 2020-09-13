import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E5_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
            .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);
        int divideBy = Integer.parseInt(reader.readLine());

        Predicate<Integer> division = e -> e % divideBy == 0;
        Consumer<Integer> printer = e -> System.out.print(e + " ");
        numbers.stream().filter(e -> !division.test(e)).forEach(printer);

    }
}
