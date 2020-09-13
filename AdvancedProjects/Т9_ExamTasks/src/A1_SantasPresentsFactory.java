import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class A1_SantasPresentsFactory {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> materials = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magicQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));


        int dolls = 0;
        int train = 0;
        int bear = 0;
        int bicycle = 0;

        boolean isListOfSourcesEmpty = false;

        while (!isListOfSourcesEmpty) {

            if (materials.isEmpty() || magicQueue.isEmpty()) {
                isListOfSourcesEmpty = true;
                continue;
            } else {
                isListOfSourcesEmpty = false;
            }

            int currentMagicLevel = magicQueue.peek();
            int currentMaterials = materials.peek();


            if (currentMagicLevel == 0 || currentMaterials == 0) {

                if (currentMagicLevel == 0) {
                    magicQueue.poll();

                }
                if (currentMaterials == 0) {
                    materials.poll();

                }
                continue;
            }

            int product = currentMaterials * currentMagicLevel;


            if (product < 0) {
                int sum = magicQueue.poll() + materials.pop();
                materials.push(sum);
                continue;
            }

            switch (product) {
                case 150:
                    dolls += 1;
                    materials.pop();
                    magicQueue.poll();
                    break;
                case 250:
                    train++;
                    materials.pop();
                    magicQueue.poll();
                    break;
                case 300:
                    bear++;
                    materials.pop();
                    magicQueue.poll();
                    break;
                case 400:
                    bicycle++;
                    materials.pop();
                    magicQueue.poll();
                    break;
                default:
                    magicQueue.poll();
                    int sum = materials.pop() + 15;
                    materials.push(sum);
                    break;

            }

        }


        Map<String, Integer> countOfToys = new LinkedHashMap<>();
        countOfToys.put("Doll", dolls);
        countOfToys.put("Wooden train", train);
        countOfToys.put("Teddy bear", bear);
        countOfToys.put("Bicycle", bicycle);

        boolean hasPresentsFirst = dolls != 0 && train != 0;
        boolean hasPresentsSecond = bear != 0 && bicycle != 0;


        if (hasPresentsFirst || hasPresentsSecond) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }


        StringBuilder result = new StringBuilder();
        if (materials.size() > 0) {
            result.append("Materials left: ");
            for (Integer material : materials) {
                result.append(material).append(", ");
            }
            System.out.println(result.toString().substring(0, result.lastIndexOf(",")));
        }

        result.setLength(0);

        if (magicQueue.size() > 0) {
            result.append("Magic left: ");
            for (Integer integer : magicQueue) {
                result.append(integer).append(", ");
            }
            System.out.println(result.toString().substring(0, result.lastIndexOf(",")));
        }

        countOfToys.entrySet().stream()
                .filter(c -> c.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

}
