import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class E7_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], Integer> minIndex = numbers -> {
            int smallestElement = numbers[0];
            int index = 0;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] <= smallestElement) {
                    smallestElement = numbers[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(minIndex.apply(Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray()));

    }
}
