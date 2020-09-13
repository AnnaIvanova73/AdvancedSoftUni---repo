import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E3_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).min().getAsInt());

    }
}
