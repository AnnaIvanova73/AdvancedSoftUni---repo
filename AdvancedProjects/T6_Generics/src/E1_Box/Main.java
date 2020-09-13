package E1_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Box<String> box;
        while (count-- > 0) {
            String input = reader.readLine();
            box = new Box<>(input);
            System.out.println(box.toString());
        }


    }
}
