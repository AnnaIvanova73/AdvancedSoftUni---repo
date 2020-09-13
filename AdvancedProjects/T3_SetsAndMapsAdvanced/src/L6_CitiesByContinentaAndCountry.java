import java.util.*;

public class L6_CitiesByContinentaAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCount = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> places = new LinkedHashMap<>();
        while (inputCount-- > 0){

            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if(!places.containsKey(continent)){
                places.put(continent,new LinkedHashMap<>());
            }

            if(places.containsKey(continent)){

                if(!places.get(continent).containsKey(country)){
                    places.get(continent).put(country,new ArrayList<>());
                }
                places.get(continent).get(country).add(city);
            }
        }

        places.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {
                System.out.print(key1 + " -> ");
                System.out.println(String.join(", ",value1));
            });
        });
    }
}
