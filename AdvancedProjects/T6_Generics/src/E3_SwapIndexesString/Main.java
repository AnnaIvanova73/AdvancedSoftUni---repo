package E3_SwapIndexesString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(reader.readLine());

        Swap<String> swap = new Swap<>();
        while (counter-- > 0) {
            swap.add(reader.readLine());
        }

        int[] swapIndexes = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        swap.makeASwap(swapIndexes[0], swapIndexes[1]);

        System.out.println(swap.toString());
    }
}
