import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Exercise_Task_6_BalancedParentheses_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("");
        boolean areBalanced = false;

        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }
        String lookupTable = "{[(";

        ArrayDeque<String> stack = new ArrayDeque<>();


        for (String element : input) {

            if (lookupTable.contains(element)) {
                stack.push(element);
            } else if (!stack.isEmpty()) {
                String current = stack.pop();

                if (current.equals("{") && element.equals("}") ||
                        current.equals("[") && element.equals("]") ||
                        current.equals("(") && element.equals(")")) {
                    areBalanced = true;
                    break;
                }
                areBalanced=false;
                break;
            }
        }

        if (!areBalanced) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

