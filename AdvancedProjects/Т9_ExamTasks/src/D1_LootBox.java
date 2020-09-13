import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class D1_LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> firstBoxAsQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxAsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxAsStack::push);


        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBoxAsQueue.isEmpty() && !secondBoxAsStack.isEmpty()) {
            int sum = firstBoxAsQueue.peek() + secondBoxAsStack.peek();

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBoxAsQueue.poll();
                secondBoxAsStack.pop();
                continue;
            }

            firstBoxAsQueue.offer(secondBoxAsStack.pop());
        }


        int finalSum = claimedItems.stream().reduce(0, Integer::sum);

        String perPrint = secondBoxAsStack.size() > 0 ? "First lootbox is empty" : "Second lootbox is empty";

        System.out.println(perPrint);

        String loot = finalSum >= 100 ? String.format("Your loot was epic! Value: %d", finalSum)
                : String.format("Your loot was poor... Value: %d", finalSum);

        System.out.println(loot);
    }
}
