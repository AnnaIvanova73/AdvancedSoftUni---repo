import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> firstBox = offerInQueue(reader);

        Deque<Integer> secondBox = new ArrayDeque<>();
        pushInTheStack(reader, secondBox);

        List<Integer> claimedItems = new ArrayList<>();
        while(!firstBox.isEmpty() && !secondBox.isEmpty()){
            int sum = firstBox.peek() + secondBox.peek();

            if(sum % 2 == 0){
                claimedItems.add(sum);
                firstBox.poll();
                secondBox.pop();
            }else{
                int item = secondBox.pop();
                firstBox.push(item);
            }
        }

        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        int reduce = claimedItems.stream().reduce(0, Integer::sum);

        if(reduce >= 100){
            System.out.println(String.format("Your loot was epic! Value: %d",reduce));
        }else{
            System.out.println(String.format("Your loot was poor... Value: %d",reduce));
        }

    }

    private static ArrayDeque<Integer> offerInQueue(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static void pushInTheStack(BufferedReader reader, Deque<Integer> secondBox) throws IOException {
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox :: push);
    }
}
