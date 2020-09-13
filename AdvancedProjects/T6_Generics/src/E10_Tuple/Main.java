package E10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int inputLine = 3;
        while (inputLine-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            switch (inputLine) {
                case 2: {
                    String name = tokens[0] + " " + tokens[1];
                    Tuple<String, String> tuple = new Tuple<>(name, tokens[2]);
                    System.out.println(tuple.getItem1() + " -> " + tuple.getItem2());
                    break;
                }
                case 1:
                    Tuple<String, Integer> tuple = new Tuple<>(tokens[0], Integer.parseInt(tokens[1]));
                    System.out.println(tuple.getItem1() + " -> " + tuple.getItem2());
                    break;
                default:
                    Tuple<Integer, Double> tuple1 = new Tuple<>(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));
                    System.out.println(tuple1.getItem1() + " -> " + tuple1.getItem2());
                    break;
            }
        }
    }
}
