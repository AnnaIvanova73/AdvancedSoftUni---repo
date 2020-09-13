import java.util.ArrayDeque;
import java.util.Scanner;

public class E6_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("");

        ArrayDeque<String> parentheses = new ArrayDeque<>();

        boolean hasBalance = true;

        if(input.length % 2 != 0){
            hasBalance = false;
        }

        String lookupTable = "{[(";
        int countOperations = input.length;
        int count = 0;
        while (countOperations-- > 0 && hasBalance) {
            String currElement = input[count];

            if(lookupTable.contains(currElement)){
                parentheses.push(currElement);
            }else{
                if(parentheses.isEmpty()){
                    break;
                }
                String pr = parentheses.pop();
                hasBalance = (pr.equals("(") && currElement.equals(")"))
                        || pr.equals("{") && currElement.equals("}")
                        || pr.equals("[") && currElement.equals("]");
            }
            count++;
        }

        if (hasBalance) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
