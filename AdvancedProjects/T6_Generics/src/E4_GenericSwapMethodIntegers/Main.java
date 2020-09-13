package E4_GenericSwapMethodIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputLines = Integer.parseInt(reader.readLine());


        Swap<Integer> collection  = new Swap<>();
        while(inputLines -- > 0){
            int number = Integer.parseInt(reader.readLine());
            collection.add(number);
        }

        int[] indexesSwap = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        collection.swapIndexes(indexesSwap[0],indexesSwap[1]);

        System.out.println(collection.toString());
    }
}
