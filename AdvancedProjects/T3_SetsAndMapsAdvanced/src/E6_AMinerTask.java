import java.util.*;

public class E6_AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Long>> resourcesAndQuantity = new LinkedHashMap<>();
        String input = "";
        int countLines = 1;

        String saveRecourse = "";
        while (!"stop".equals(input = scan.nextLine())) {

            if (countLines % 2 == 0) {
                long quantity = Integer.parseInt(input);
                resourcesAndQuantity.get(saveRecourse).add(quantity);
                ;

            } else {
                saveRecourse = input;
                resourcesAndQuantity.putIfAbsent(input, new ArrayList<>());
            }

            countLines++;
        }

        resourcesAndQuantity.forEach((key, value) -> {
            long sum = value.stream().mapToLong(i -> i).sum();
            System.out.printf("%s -> %d%n", key,sum);
        });
    }
}
