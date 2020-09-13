import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_Task_4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int numbersToAdd = scan.nextInt();
        int numbersToRemove = scan.nextInt();
        int numberSearched = scan.nextInt();
        scan.nextLine();

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split("\\s+"))
                .limit(numbersToAdd)
                .mapToInt(e -> Integer.parseInt(e))
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));


        for (int i = 0; i < numbersToRemove; i++) {
            queue.poll();
        }

        if (queue.contains(numberSearched)) {
            System.out.println("true");

        } else {
            System.out.println(queue.stream().min(Integer::compareTo).orElse(0));
        }


    }
}
