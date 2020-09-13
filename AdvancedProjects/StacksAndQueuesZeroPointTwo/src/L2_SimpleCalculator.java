import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expresionInput = scan.nextLine();

        ArrayDeque<String> expresion =
                Arrays.stream(expresionInput.split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        while(expresion.size() > 1){

            int num1 = Integer.parseInt(expresion.pop());
            char operator = expresion.pop().charAt(0);
            int num2 = Integer.parseInt(expresion.pop());

            if(operator == '+'){
                int result = num1 + num2;
                expresion.push(String.valueOf(result));
            }else{
                int result = num1 - num2;
                expresion.push(String.valueOf(result));
            }

        }
        String result = expresion.toString();
        System.out.println(result.replaceAll("\\D+",""));
    }
}
