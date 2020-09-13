import java.util.*;
import java.util.stream.Collectors;
public class Lab_Task_6_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> kids = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        int count = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>(kids);

        while (queue.size() > 1){

            for (int i = 1; i < count ; i++) {
                String name = queue.poll();
                assert name != null;
                queue.offer(name);
            }
            System.out.println("Removed " + queue.poll());

        }
        System.out.println("Last is " + queue.poll());
    }
}
