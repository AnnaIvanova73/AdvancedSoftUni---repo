import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Lab_Task_3_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimal = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        if(decimal == 0){
            System.out.println(0);
        }
        while(decimal != 0 ){
            stack.push(String.valueOf(decimal % 2));
            decimal/=2;
        }
        List<String> result  = new ArrayList<>(stack);
        System.out.println(String.join("",result));
    }
}
