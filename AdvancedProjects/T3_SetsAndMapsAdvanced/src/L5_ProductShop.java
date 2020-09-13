import java.util.*;

public class L5_ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String,Double>> shopsProductAndPrices = new HashMap<>();

        String input = "";

        while(!"Revision".equals(input = scan.nextLine())){

            String[] tokens = input.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopsProductAndPrices.putIfAbsent(shop, new LinkedHashMap<>());

            if(shopsProductAndPrices.containsKey(shop)){
                shopsProductAndPrices.get(shop).put(product,price);
            }
        }

        shopsProductAndPrices.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(s ->{
                    System.out.println(s.getKey() + "->");
                    s.getValue().forEach((key, value) -> System.out.println(String.format("Product: %s, Price: %.1f",key,value)));
                });
    }
}
