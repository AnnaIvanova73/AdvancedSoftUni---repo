import java.util.ArrayDeque;
import java.util.Scanner;
// 50 / 100

public class Lab_Task_8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackUrl = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = "";

        while (!"Home".equals(input = scanner.nextLine())) {
            if ("back".equals(input)) {

                if (stackUrl.size() > 1) {
                    String toRemove = stackUrl.pop();
                    forwardStack.push(toRemove);
                    System.out.println(stackUrl.peek());

                } else {
                    System.out.println("no 100 ot 100 URLs");
                }
                continue;
            }
            if ("forward".equals(input)) {

                if (forwardStack.size() > 0) {
                    String currentForward = forwardStack.pop();
                    System.out.println(currentForward);
                    stackUrl.push(currentForward);
                } else {
                    System.out.println("no next URLs");
                }
                continue;
            }
            System.out.println(input);
            stackUrl.push(input);
            forwardStack.clear();
        }
    }
}
