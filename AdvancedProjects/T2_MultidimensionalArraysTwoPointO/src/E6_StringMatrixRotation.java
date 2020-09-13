import java.util.*;
import java.util.stream.Collectors;

public class E6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int degrees = Integer.parseInt(scan.nextLine().replaceAll("[^0-9]+", "")) % 360;
        boolean isOutPutEqualInput = degrees == 0;

        List<List<String>> words = new LinkedList<>();
        int largerElement = Integer.MIN_VALUE;

        String input = "";
        while (!"END".equals(input = scan.nextLine())) {
            if (isOutPutEqualInput) {
                System.out.println(input);
            } else {
                List<String> elements = Arrays.stream(input.split("")).collect(Collectors.toList());
                words.add(elements);
                if (largerElement < elements.size()) {
                    largerElement = elements.size();
                }
            }
        }


        switch (degrees) {
            case 90:
                rotate90(words, largerElement);
                break;
            case 180:
                rotate180(words);
                break;
            case 270:
                rotate270(words, largerElement);
                break;
        }
    }

    private static void rotate90(List<List<String>> words, int largerElement) {
        int counter = 0;
        while (counter < largerElement) {
            StringBuilder currentSymbols = new StringBuilder();
            for (int row = words.size() - 1; row >= 0; row--) {

                if (counter < words.get(row).size()) {
                    currentSymbols.append(words.get(row).get(counter));
                } else {
                    currentSymbols.append(" ");
                }
            }
            System.out.println(currentSymbols.toString());
            currentSymbols.setLength(0);
            counter++;
        }
    }


    private static void rotate180(List<List<String>> words) {
        for (int row = words.size() - 1; row >= 0; row--) {
            for (int col = words.get(row).size() - 1; col >= 0; col--) {
                System.out.print(words.get(row).get(col));
            }
            System.out.println();
        }

    }

    private static void rotate270(List<List<String>> words, int largerElement) {
        int counter = largerElement - 1;
        while (counter >= 0) {
            StringBuilder word = new StringBuilder();
            for (int row = 0; row < words.size(); row++) {
                int size = words.get(row).size();
                if (counter < size) {
                    word.append(words.get(row).get(counter));
                } else {
                    word.append(" ");
                }
            }
            System.out.println(word.toString());
            word.setLength(0);
            counter--;
        }
    }
}
