import java.util.ArrayDeque;
import java.util.Scanner;

public class L4_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expresion = scan.nextLine();

        ArrayDeque<Integer> openingBrackets = new ArrayDeque<>();


        for (int i = 0; i < expresion.length(); i++) {
            char current = expresion.charAt(i);
            if(current == '('){
                openingBrackets.push(i);
                continue;
            }
            if(current == ')'){
                int indexBegin = openingBrackets.pop();
                String currentExpresion = expresion.substring(indexBegin,i + 1);
                System.out.println(currentExpresion);
            }
        }
    }
}
