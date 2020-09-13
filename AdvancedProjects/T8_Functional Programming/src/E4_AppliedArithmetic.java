import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E4_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<Integer, Integer> add = x -> x += 1;
        Function<Integer, Integer> mul = x -> x *= 2;
        Function<Integer, Integer> sub = x -> x -= 1;
        Function<List<Integer>, String> print =
                e -> Arrays.toString(e.toArray()).replaceAll("[\\[\\],]", "");

        String line;
        while (!(line = reader.readLine()).equals("end")) {


            switch (line) {
                case "add":
                    numbers = numbers.stream().map(add).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(mul).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(sub).collect(Collectors.toList());
                    break;
                case "print":
                    System.out.println(print.apply(numbers));
                    break;
            }
        }
    }
}
