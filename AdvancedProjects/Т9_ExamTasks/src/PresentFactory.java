import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class PresentFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> materials = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).filter(e -> e != 0).boxed().collect(Collectors.toList());

        List<Integer> magics = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).filter(e -> e != 0).boxed().collect(Collectors.toList());


        Map<String, Integer> presents = new TreeMap<>();

        while (!materials.isEmpty() && !magics.isEmpty()) {
            int material = materials.get(materials.size() - 1);
            int magic = magics.get(0);
            int multiplication = material * magic;

            materials.remove(materials.size() - 1);
            magics.remove(0);
            if (multiplication < 0) {
                if (material + magic != 0) {
                    materials.add(material + magic);
                }
            } else {
                switch (multiplication) {
                    case 150:
                        presents.putIfAbsent("Doll", 0);
                        presents.put("Doll", presents.get("Doll") + 1);
                        break;
                    case 250:
                        presents.putIfAbsent("Wooden train", 0);
                        presents.put("Wooden train", presents.get("Wooden train") + 1);
                        break;
                    case 300:
                        presents.putIfAbsent("Teddy bear", 0);
                        presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                        break;
                    case 400:
                        presents.putIfAbsent("Bicycle", 0);
                        presents.put("Bicycle", presents.get("Bicycle") + 1);
                        break;
                    default:
                        materials.add(material + 15);
                        break;
                }
            }

        }

        StringBuilder builder = new StringBuilder();
        if ((presents.containsKey("Doll") && presents.containsKey("Wooden train")) ||
                (presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"))) {
            builder.append("The presents are crafted! Merry Christmas!");
        } else {
            builder.append("No presents this Christmas!");
        }
        appendingItems(materials, magics, builder);
        System.out.println(builder);
        presents.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void appendingItems(List<Integer> materials, List<Integer> magics, StringBuilder builder) {
        if (!materials.isEmpty()) {
            builder.append(System.lineSeparator());
            builder.append("Materials left: ");
            Collections.reverse(materials);
            for (Integer material : materials) {
                builder.append(String.format("%d, ", material));
            }
            builder.delete(builder.length() - 2, builder.length());
        } else if (!magics.isEmpty()){
            builder.append(System.lineSeparator());
            builder.append("Magics left: ");
            Collections.reverse(magics);
            for (Integer magic : magics) {
                builder.append(String.format("%d, ", magic));
            }
            builder.delete(builder.length() - 2, builder.length());
        }
    }
}