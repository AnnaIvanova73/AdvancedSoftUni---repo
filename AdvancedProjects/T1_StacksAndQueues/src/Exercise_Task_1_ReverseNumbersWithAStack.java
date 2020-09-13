import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_Task_1_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack  = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(stack::push);

        StringBuilder output = new StringBuilder();
        while(stack.size() > 0){
            output.append(stack.pop() + " ");
        }
        System.out.println(output.toString().trim());

    }
}
