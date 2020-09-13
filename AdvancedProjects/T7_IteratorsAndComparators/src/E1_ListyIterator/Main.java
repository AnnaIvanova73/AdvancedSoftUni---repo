package E1_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = Arrays.stream(reader.readLine().split("\\s+")).skip(1).toArray(String[]::new);



        ListyIterator<String> list = new ListyIterator<>(input);

        String line;

        while(!(line = reader.readLine()).equals("END")){
            switch (line){
                case"Move":
                    System.out.println(list.moveIndex());
                    break;
                case"Print":
                    try {
                        System.out.println(list.getElement());
                    }catch (IndexOutOfBoundsException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case"HasNext":
                    System.out.println(list.hasNext());
                    break;
            }
        }
    }
}
