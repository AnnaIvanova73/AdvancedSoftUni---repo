import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13_SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> artistsConcertData = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-z ])*?( )@[a-zA-z ]+ [0-9]+ [0-9]+");

        String input = "";
        while (!"End".equals(input = scan.nextLine())) {

            if (!input.matches(String.valueOf(pattern))) {
                continue;
            }

            String name = input.split("@")[0].trim();
            String town = findCity(input);
            double amountMoney = findPrice(input) * findTicketsCount(input);

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

    private static int findTicketsCount(String input) {
        int index = input.lastIndexOf(' ');
        return Integer.parseInt(input.substring(index + 1));
    }

    private static int findPrice(String input) {
        int b = findIndexOfFirstDigit(input);
        int e = input.lastIndexOf(' ');
        return Integer.parseInt(input.substring(b, e));
    }

    private static String findCity(String input) {
        String town = input.split("@")[1].trim();
        int index = findIndexOfFirstDigit(town);
        return town.substring(0, index - 1).trim();
    }

    private static int findIndexOfFirstDigit(String town) {
        int index = 0;
        for (int i = 0; i < town.length(); i++) {
            char ch = town.charAt(i);
            if (Character.isDigit(ch)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
