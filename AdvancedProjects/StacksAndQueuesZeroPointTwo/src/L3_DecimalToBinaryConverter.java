import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L3_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        if(num == 0){
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        while(num != 0){
           int result =  num % 2;
            binaryStack.push(result);
            num /=2;
        }

        while(binaryStack.size() > 0){
            System.out.print(binaryStack.pop());
        }
    }
}
