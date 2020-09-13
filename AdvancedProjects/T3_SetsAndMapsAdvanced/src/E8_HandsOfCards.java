import java.util.*;
import java.util.stream.Collectors;

public class E8_HandsOfCards {

    private static Map<String, Double> powerOfCards = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> playersAndCards = new LinkedHashMap<>();

        String input = "";
        while (!"JOKER".equals(input = scan.nextLine())) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            Set<String> cards = Arrays.stream(tokens[1].split(", "))
                    .map(String::toString)
                    .collect(Collectors.toCollection(HashSet::new));

            if (!playersAndCards.containsKey(name)) {
                playersAndCards.put(name, cards);
            } else {
                playersAndCards.get(name).addAll(cards);
            }
        }

        calculatePowerOfCards(playersAndCards);

        powerOfCards.forEach((key, value) -> System.out.printf("%s: %.0f%n", key, value));
    }

    private static void calculatePowerOfCards(Map<String, Set<String>> playersAndCards) {

        for (Map.Entry<String, Set<String>> entrySet : playersAndCards.entrySet()) {
            String player = entrySet.getKey();
            Set<String> playerDecks = entrySet.getValue();

            for (String playerDeck : playerDecks) {
                String multiplyPower = String.valueOf(playerDeck.charAt(0));
                String typeOfTheCard = String.valueOf(playerDeck.charAt(1));
                if (playerDeck.length() == 3) {
                    multiplyPower = String.valueOf(10);
                    typeOfTheCard = String.valueOf(playerDeck.charAt(2));
                }

                putPlayerWithCurrentPower(player, multiplyPower, typeOfTheCard);

            }
        }
    }

    private static void putPlayerWithCurrentPower(String player, String multiplyPower, String typeOfTheCard) {
        String lookUpTable = "JQKA";

        int multiplayer = 0;
        if (lookUpTable.contains(multiplyPower)) {
            String letter = letterPower(multiplyPower);
            multiplayer = Integer.parseInt(letter);
        } else {
            multiplayer = Integer.parseInt(multiplyPower);
        }

        double type = Double.parseDouble(letterPower(typeOfTheCard));

        double result = multiplayer * type;

        if (!powerOfCards.containsKey(player)) {
            powerOfCards.put(player, result);
        } else {
            double currResult = powerOfCards.get(player);
            double newResult = currResult + result;
            powerOfCards.put(player, newResult);
        }
    }

    private static String letterPower(String multiplyPower) {
        Map<String, String> temp = Map.of("J", "11", "Q", "12", "K", "13", "A", "14",
                "S", "4", "H", "3", "D", "2", "C", "1");
        return temp.get(multiplyPower);
    }
}
