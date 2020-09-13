import java.util.*;
import java.util.stream.Collectors;

public class Exercise_Task_6_StringMatrixRotation {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        int rotation = Integer.parseInt(scan.nextLine().replaceAll("\\D+", ""));
        rotation %= 360;
        StringBuilder result = new StringBuilder();

        if (rotation == 0) {
            String input = "";
            while (!"END".equals(input = scan.nextLine())) {
                result.append(input).append(System.lineSeparator());
            }
            printResult(result);
            return;
        }

        List<List<String>> words = new ArrayList<>();
        String input = scan.nextLine();
        int maxSymbols = -1;
        while (!"END".equals(input)) {
            List<String> current = Arrays.stream(input.split("")).collect(Collectors.toList());
            words.add(current);
            if (maxSymbols < current.size()) {
                maxSymbols = current.size();
            }
            input = scan.nextLine();
        }

        switch (rotation) {
            case 90:
                rotateAndPrint90(words, maxSymbols,result);
                break;
            case 180:
                rotateAndPrint180(words,result);
                break;
            case 270:
                rotateAndPrint270(words, maxSymbols,result);
                break;
        }
    }

    private static void rotateAndPrint270(List<List<String>> words, int length, StringBuilder result) {
        length -= 1;
        while (0 <= length) {
            for (List<String> word : words) {
                int sizeWord = word.size();
                if (sizeWord <= length) {
                    result.append(" ");
                } else {
                    result.append(word.get(length));
                }
            }
            result.append(System.lineSeparator());
            length--;
        }
        printResult(result);
    }

    private static void rotateAndPrint180(List<List<String>> words, StringBuilder result) {
        for (int row = words.size() - 1; row >= 0; row--) {
            for (int col = words.get(row).size() - 1; col >= 0; col--) {
                result.append(words.get(row).get(col));
            }
            result.append(System.lineSeparator());
        }
        printResult(result);
    }

    private static void rotateAndPrint90(List<List<String>> words, int length, StringBuilder result) {
        int count = 0;
        while (count < length) {
            for (int row = words.size() - 1; row >= 0; row--) {
                int sizeWord = words.get(row).size();
                if (sizeWord <= count) {
                    result.append(" ");
                } else {
                    result.append(words.get(row).get(count));
                }
            }
            result.append(System.lineSeparator());

            count++;
        }
        printResult(result);
    }

    private static void printResult(StringBuilder result) {
        System.out.println(result);
    }
}
