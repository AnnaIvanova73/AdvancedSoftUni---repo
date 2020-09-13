import java.util.ArrayDeque;
import java.util.Scanner;

public class E1_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        String[] input = scan.nextLine().split("\\s+");

        for (String currElement : input) {
            int current = Integer.parseInt(currElement);
            numbers.push(current);
        }

        while(numbers.size() > 0){
            System.out.print(numbers.pop() + " ");
        }
    }
}
