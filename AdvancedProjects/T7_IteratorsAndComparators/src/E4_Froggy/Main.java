package E4_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Lake lake = new Lake();
        String line;
        while (!(line = reader.readLine()).equals("END")) {
           Integer[] stones = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt)
                   .boxed().toArray(Integer[]::new);
           lake.setStones(stones);
        }

        StringBuilder perPrint = new StringBuilder();
        for (Integer integer : lake) {
            perPrint.append(integer).append(", ");
        }
        System.out.println(perPrint.substring(0, perPrint.lastIndexOf(", ")));
    }



}
