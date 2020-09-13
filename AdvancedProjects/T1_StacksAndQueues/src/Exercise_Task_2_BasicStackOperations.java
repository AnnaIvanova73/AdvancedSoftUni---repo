import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_Task_2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbersToPush = scan.nextInt();
        int numbersToPop = scan.nextInt();
        int searchedNumber = scan.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush ; i++) {
            numbers.push(scan.nextInt());
        }

        for (int i = 0; i <numbersToPop ; i++) {
            numbers.pop();
        }

        if(numbers.contains(searchedNumber)){
            System.out.println("true");
        }else if(numbers.size() > 0){
            System.out.println(Collections.min(numbers));
        }else{
            System.out.println(0);
        }
    }
}
