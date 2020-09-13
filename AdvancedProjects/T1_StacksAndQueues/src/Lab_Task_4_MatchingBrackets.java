import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab_Task_4_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expresion = scan.nextLine();

        ArrayDeque<Integer> stack  = new ArrayDeque<>();

        for (int i = 0; i < expresion.length() ; i++) {
            char currentElement = expresion.charAt(i);

            if('(' == currentElement){
                stack.push(i);
            }else if(')' == currentElement){
                int curr = stack.pop();
                int curr2 = i +1;
                String currentSub = expresion.substring(curr,curr2);
                //System.out.println(expresion.substring(stack.pop(), (i + 1)));
                System.out.println(currentSub);
            }
        }
    }
}
