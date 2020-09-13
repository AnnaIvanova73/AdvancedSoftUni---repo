package E9_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCommans = Integer.parseInt(reader.readLine());

        LinkedListTraversal list = new LinkedListTraversal();

        for (int i = 0; i < countCommans; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            if (tokens[0].equals("Add")) {
                list.add(Integer.parseInt(tokens[1]));
            } else {
                list.remove(Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(list.size());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
