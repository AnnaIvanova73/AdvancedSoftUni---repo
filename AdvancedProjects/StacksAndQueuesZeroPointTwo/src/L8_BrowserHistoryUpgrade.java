import java.util.ArrayDeque;
import java.util.Scanner;

public class L8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> backwardsStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = scan.nextLine();

        while (!"Home".equals(input)) {

            if ("back".equals(input)) {

                if (backwardsStack.size() > 1) {
                    String temp = backwardsStack.pop();
                    forwardStack.push(temp);
                    System.out.println(backwardsStack.peek());

                } else {
                    System.out.println("no previous URLs");
                }

                input = scan.nextLine();
                continue;
            }

            if ("forward".equals(input)) {

                if (forwardStack.size() > 0) {
                    String forwardUrl = forwardStack.poll();
                    System.out.println(forwardUrl);
                    backwardsStack.push(forwardUrl);
                } else {
                    System.out.println("no next URLs");
                }

                input = scan.nextLine();
                continue;
            }
            System.out.println(input);
            backwardsStack.push(input);
            forwardStack.clear();
            input = scan.nextLine();
        }


    }
}
