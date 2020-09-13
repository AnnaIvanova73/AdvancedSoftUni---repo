package E11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static final Set<Threeuple> data = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = splitReader(reader);

        String name = tokens[0] + " " + tokens[1];
        createThreeuple(name, tokens[2], tokens[3]);

        tokens = splitReader(reader);
        boolean isSober = tokens[2].equals("drunk");
        createThreeuple(tokens[0], Integer.parseInt(tokens[1]), isSober);


        tokens = splitReader(reader);
        createThreeuple(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);

        data.forEach(System.out::println);
    }

    private static String[] splitReader(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }

    public static void createThreeuple(String string, double num, String string1) {
        Threeuple<String, Double, String> threeple = new Threeuple<>(string, num, string1);
        data.add(threeple);
    }

    private static void createThreeuple(String string, int num, boolean isTrue) {
        Threeuple<String, Integer, Boolean> threeple = new Threeuple<>(string, num, isTrue);
        data.add(threeple);
    }

    private static void createThreeuple(String name, String token, String token1) {
        Threeuple<String, String, String> threeple = new Threeuple<>(name, token, token1);
        data.add(threeple);
    }
}
