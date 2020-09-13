package E3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        //SecondStack stackTwo = new SecondStack();
         FirstStack stack = new FirstStack();
        while (!(line = reader.readLine()).equals("END")) {
            line = line.replaceAll(",", "");
            String[] tokens = line.split("\\s+", 0);

            if (tokens[0].equals("Push")) {
                stack.push(Arrays.stream(tokens)
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new));

            } else {
                stack.pop();
            }
        }


        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println(stack.toString());
    }
}
