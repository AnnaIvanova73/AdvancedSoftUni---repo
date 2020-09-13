import java.util.*;
import java.util.stream.Collectors;
public class Lab_Task_7_MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> kids = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        int count = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>(kids);

        int cycle = 1;
        while (queue.size() > 1){

            for (int i = 1; i < count ; i++) {
                String name = queue.poll();
                assert name != null;
                queue.offer(name);
            }

            if(!isPrime(cycle)){
                System.out.println("Removed " + queue.poll() );

            }else{
                System.out.println("Prime " + queue.peek());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if(cycle == 1){
            return false;
        }
        for (int i = 2; i <cycle ; i++) {
            if(cycle % i == 0){
                return false;
            }
        }
        return true;
    }
}
