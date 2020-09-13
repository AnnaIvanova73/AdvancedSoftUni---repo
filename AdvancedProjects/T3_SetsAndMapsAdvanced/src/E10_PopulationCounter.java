import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = "";

        Map<String, Map<String, Long>> countriesData = new LinkedHashMap<>();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        while (!"report".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);


            if (!countriesData.containsKey(country) && !totalPopulation.containsKey(country)) {
                countriesData.put(country, new LinkedHashMap<>());
                countriesData.get(country).put(town, population);
                totalPopulation.put(country, population);
            } else {
                countriesData.get(country).put(town, population);
                long curr = totalPopulation.get(country);
                curr += population;
                totalPopulation.put(country, curr);
            }

        }

        totalPopulation.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(r -> {
            System.out.println(String.format("%s (total population: %d)", r.getKey(), r.getValue()));
            countriesData.get(r.getKey()).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                    .forEach((v) -> System.out.println(String.format("=>%s: %d", v.getKey(), v.getValue())));

        });


    }
}
