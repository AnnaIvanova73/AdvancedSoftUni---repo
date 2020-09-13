import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13_SerbianUnleashed1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> artistsConcertData = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-z ]*?)( )@([a-zA-z ]+) ([0-9]+) ([0-9]+)");

        String input = "";
        while (!"End".equals(input = scan.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                continue;
            }

            String name = matcher.group(1);
            String town = matcher.group(3);
            int count = Integer.parseInt(matcher.group(4));
            int price = Integer.parseInt(matcher.group(5));
            double amountMoney = price * count;

            if (!artistsConcertData.containsKey(town)) {
                artistsConcertData.put(town, new LinkedHashMap<>());
            }

            if (!artistsConcertData.get(town).containsKey(name)) {
                artistsConcertData.get(town).put(name, amountMoney);
            } else {
                double currentSome = artistsConcertData.get(town).get(name);
                currentSome += amountMoney;
                artistsConcertData.get(town).put(name, currentSome);
            }
        }

        artistsConcertData.forEach((key, value) -> {
            System.out.println(key);

            value.entrySet().stream().sorted((a, b) -> {
                double comp = b.getValue() - a.getValue();
                return (int) comp;
            }).forEach(v -> {
                System.out.println(String.format("#  %s -> %.0f", v.getKey(), v.getValue()));
            });
        });
    }
}
