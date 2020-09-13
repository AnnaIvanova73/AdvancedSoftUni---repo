import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_Task_3_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int commandsCount = scan.nextInt();

        while (commandsCount-- > 0) {
            int commands = scan.nextInt();

            switch (commands) {
                case 1:
                    int number = scan.nextInt();
                    stack.push(number);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxNum = stack.stream().max(Integer :: compareTo).orElse(0);
                    System.out.println(maxNum);
                    break;
            }
        }
    }
}
