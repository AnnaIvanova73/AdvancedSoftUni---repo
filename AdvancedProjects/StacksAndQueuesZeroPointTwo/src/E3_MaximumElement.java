import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E3_MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countCommands = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countCommands ; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            switch (tokens[0]){
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                        stack.push(element);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxElement = 0;
                    if (stack.size() > 0) {
                        maxElement = Collections.max(stack);
                    }
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
