import java.util.*;

public class E12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyMaterial = new TreeMap<>(Map.of("shards", 0, "fragments", 0, "motes", 0));
        Map<String, String> lookUpTable = Map.of("shards", "Shadowmourne obtained!", "fragments", "Valanyr obtained!",
                "motes", "Dragonwrath obtained!");
        Map<String, Integer> junk = new TreeMap<>();

        boolean hadAWinner = false;

        while (!hadAWinner) {
            String[] input = scan.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);

                if (keyMaterial.containsKey(material)) {
                    int prQuantity = calculateNewValue(keyMaterial, material, quantity);
                    keyMaterial.put(material, prQuantity);

                    if(isMarkReached(keyMaterial,material)){
                        System.out.println(lookUpTable.get(material));
                        hadAWinner = true;
                        break;
                    }
                }else{
                    junk.putIfAbsent(material,0);
                    int prQuantity = calculateNewValue(junk, material, quantity);
                    junk.put(material,prQuantity);
                }
            }
        }

        keyMaterial.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(a-> System.out.println(a.getKey() + ": " + a.getValue()));
        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static int calculateNewValue(Map<String, Integer> keyMaterial, String material, int quantity) {
        int prQuantity = keyMaterial.get(material);
        prQuantity += quantity;
        return prQuantity;
    }

    private static boolean isMarkReached(Map<String, Integer> keyMaterial, String material) {
        int value = keyMaterial.get(material);
        if(value >= 250){
            int reduce = keyMaterial.get(material);
            reduce-=250;
            keyMaterial.put(material,reduce);
            return true;
        }
        return false;
    }
}
