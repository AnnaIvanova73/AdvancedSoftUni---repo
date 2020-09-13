import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Exercise_Task_7_RecursiveFibonacci {
    private static long[] memory;

    public static void main(String[] args) throws IOException {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        memory = new long [n + 1];

        long result = fibonacci(n);

        System.out.println(result);
    }

    private static long fibonacci(int n) {
        if(n < 2){
            return 1;
        }

        if(memory[n] !=0){
            return memory[n];
        }

        return memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
