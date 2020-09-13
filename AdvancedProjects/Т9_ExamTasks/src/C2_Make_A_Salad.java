import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class C2_Make_A_Salad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> vegyCalories = new HashMap<>();
        vegyCalories.put("tomato", 80);
        vegyCalories.put("carrot", 136);
        vegyCalories.put("lettuce", 109);
        vegyCalories.put("potato", 215);


        ArrayDeque<String> vegetablesQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toString)
                .filter(x -> x.matches("(tomato|carrot|lettuce|potato)"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(caloriesStack::push);


        List<String> saladsList = new ArrayList<>();

        while (!vegetablesQueue.isEmpty() && !caloriesStack.isEmpty()) {

            int current = caloriesStack.peek();

            while (current > 0 && !vegetablesQueue.isEmpty()) {
                int asd = vegyCalories.get(vegetablesQueue.poll());
                current -= asd;
            }

            int dsa = caloriesStack.pop();
            saladsList.add(String.valueOf(dsa));

        }
        System.out.println(String.join(" ", saladsList));

        if (!caloriesStack.isEmpty()) {
            caloriesStack.forEach(e -> System.out.print(e + " "));
        }

        if (!vegetablesQueue.isEmpty()) {
            System.out.println(String.join(" ", vegetablesQueue));
        }
    }


}
