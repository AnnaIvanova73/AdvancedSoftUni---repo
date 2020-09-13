import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_Task_6_BalancedParentheses_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String parentheses = scan.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        String lookupTable = "{([";

        boolean areBalanced = true;

        for (int i = 0; i < parentheses.length() ; i++) {
            char symbol = parentheses.charAt(i);

            if(lookupTable.contains(String.valueOf(symbol))){
                stack.push(symbol);
            }else{
                if(stack.isEmpty()){
                    areBalanced=false;
                    break;
                }
                char lastIn = stack.pop();

                if(!(lastIn == '(' && symbol ==')'
               || lastIn == '[' && symbol == ']'
               || lastIn == '{' && symbol == '}')){

                    areBalanced=false;
                    break;
                }
            }
        }

        String output = areBalanced ? "YES" : "NO";
        System.out.println(output);

    }
}
