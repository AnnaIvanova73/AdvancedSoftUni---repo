import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class E9_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<int[], Integer> predicate = (arr, num) -> {
            for (int i : arr) {
                if (num % i != 0) {
                    return false;
                }
            }
            return true;
        };


        for (int i = 1; i <= input; i++) {
            if (predicate.test(numbers, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
