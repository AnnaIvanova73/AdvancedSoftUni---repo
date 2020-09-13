import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L7_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String kids = scan.nextLine();
        ArrayDeque<String> queueOfKids =
                Arrays.stream(kids.split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        int hotPotato = scan.nextInt();

        int counter = 1;
        while(queueOfKids.size() > 1){

            for (int i = 1; i < hotPotato ; i++) {
                String name = queueOfKids.poll();
                if (name != null) {
                    queueOfKids.offer(name);
                }
            }
            if(isPrime(counter)){
                System.out.println("Prime " + queueOfKids.peek());
            }else{
                System.out.println("Removed " + queueOfKids.poll());
            }

            counter++;
        }

        System.out.println("Last is " + queueOfKids.poll());
    }
    private static boolean isPrime (int cycle) {
        if(cycle == 1){
            return false;
        }
        for (int i = 2; i < cycle ; i++) {
            if(cycle % i == 0){
                return false;
            }
        }
        return true;
    }
}
