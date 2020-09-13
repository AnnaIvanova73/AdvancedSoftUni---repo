import java.util.*;
import java.util.stream.Collectors;

public class Lab_Task_2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> collect = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());


        ArrayDeque<String> stackOfNumbers = new ArrayDeque<>(collect);

        while(stackOfNumbers.size() > 1){

            int digit = Integer.parseInt(stackOfNumbers.pop());
            char sign = stackOfNumbers.pop().charAt(0);
            int digit2 = Integer.parseInt(stackOfNumbers.pop());
            if (sign == '+') {
                stackOfNumbers.push(String.valueOf(digit + digit2));
            } else {
                stackOfNumbers.push(String.valueOf(digit - digit2));
            }
        }
        collect = new ArrayList<>(stackOfNumbers);
        System.out.println(String.join("",collect));
      //  System.out.println(stackOfNumbers.peek());
    }
}
