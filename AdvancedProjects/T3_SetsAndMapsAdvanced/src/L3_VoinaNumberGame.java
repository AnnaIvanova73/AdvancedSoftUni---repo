import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L3_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 50;

        while (rounds-- > 0) {
            Iterator<Integer> firstIterator = firstPlayer.iterator();
            int firstPlayerCard = firstIterator.next();
            firstIterator.remove();

            int secondPlayerCard = getFirstCard(secondPlayer);
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {

                firstPlayer.addAll(Arrays.asList(firstPlayerCard, secondPlayerCard));

            } else if (secondPlayerCard > firstPlayerCard) {

                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }

            if (secondPlayer.isEmpty() || firstPlayer.isEmpty()) {
                break;
            }

        }

        String output = "Draw";
        if (firstPlayer.size() > secondPlayer.size()) {
            output = "First player win!";
        }
        if (secondPlayer.size() > firstPlayer.size()) {
            output = "Second player win!";
        }

        System.out.println(output);
    }

    private static int getFirstCard(LinkedHashSet<Integer> secondPlayer) {
        for (Integer card : secondPlayer) {
            return card;
        }
        return 0;
    }
}
