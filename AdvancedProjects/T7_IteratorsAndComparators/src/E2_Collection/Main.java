package E2_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstCommand = Arrays.stream(reader.readLine().split("\\s+")).skip(1).toArray(String[]::new);

        MyList<String> myList = new MyList<>(firstCommand);
        MyList2<String> listTwo = new MyList2<>(firstCommand);

        String line;

        while (!(line = reader.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");


            switch (tokens[0]){
                case "Move":
                    System.out.println(myList.move());
                    break;
                case"Print":
                    try{
                        myList.print();
                    } catch (IndexOutOfBoundsException es){
                        System.out.println(es.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(myList.hasNext());
                    break;
                case"PrintAll":
                    System.out.println(myList.toString());
                    System.out.println(listTwo.toString() + "secondCollection");
                    break;
            }

        }

    }
}
