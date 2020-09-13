import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pushElements = scan.nextInt();
        int popElements = scan.nextInt();
        int neededNumber = scan.nextInt();
        scan.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .limit(pushElements).mapToInt(Integer::parseInt).forEach(stack :: push);

        int smallestElement = Integer.MAX_VALUE;

        for (int i = 0; i < popElements; i++) {
            if(stack.size() != 0){
                stack.pop();
            }
        }

        if(stack.size() == 0){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < stack.size(); i++) {
            int num = stack.pop();

            if(num == neededNumber){
                System.out.println("true");
                return;
            }
            if(num < smallestElement){
                smallestElement = num;
            }
            i--;
        }
            System.out.println(smallestElement);

    }
}
