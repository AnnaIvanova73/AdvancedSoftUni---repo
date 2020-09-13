package E8_CustomListSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> elements = new CustomList<>();
        String line;
        while (!(line = reader.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];


            switch (cmd) {
                case "Add":
                    elements.addElement(tokens[1]);
                    break;
                case "Remove":
                    elements.removeElement(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    if (elements.containsElement(tokens[1])) {
                        System.out.println("true");
                    }else{
                        System.out.println("false");
                    }
                    break;
                case "Swap":
                    elements.swapIndexes(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(elements.getCountGreater(tokens[1]));
                    break;
                case "Max":
                    System.out.println(elements.getMax());
                    break;
                case "Min":
                    System.out.println(elements.getMin());
                    break;
                case"Sort":
                   Sorter.sort(elements);
                    break;
                case "Print":
                   // elements.printList();
                    for (String element : elements) {
                        System.out.println(element);
                    }
                    break;
            }
        }
    }
}
