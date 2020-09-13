import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E4_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        Map<Character, Integer> charElementsOccurrences = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (!charElementsOccurrences.containsKey(current)) {
                charElementsOccurrences.put(current, 1);
            } else {
                int previousValue = charElementsOccurrences.get(current);
                charElementsOccurrences.put(current, previousValue + 1);
            }

        }

        charElementsOccurrences.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(a->{
            System.out.println(a.getKey() + ": " + a.getValue() + " time/s");
        });
    }
}
