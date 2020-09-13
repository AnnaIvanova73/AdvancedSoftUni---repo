import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L6_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String kids = scan.nextLine();
        ArrayDeque<String> queueOfKids =
                Arrays.stream(kids.split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        int hotPotato = scan.nextInt();

        while(queueOfKids.size() > 1){

            for (int i = 1; i < hotPotato ; i++) {
                String name = queueOfKids.poll();
                if (name != null) {
                    queueOfKids.offer(name);
                }
            }

            System.out.println("Removed " + queueOfKids.poll());
        }

        System.out.println("Last is " + queueOfKids.poll());
    }
}
