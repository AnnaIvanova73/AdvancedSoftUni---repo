import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1_L7_RecursiveFibonacci {
    private static long [] memoization;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        memoization = new long[num + 1];

        long fibonacci = calculateFibonacci(num);
        System.out.println(fibonacci);
    }

    private static long calculateFibonacci(int num) {
        if(num < 2){
            return 1;
        }
        if (memoization[num] != 0) {
            return memoization[num];
        }
        List<Integer> asd = new ArrayList<>();
        asd.add(2);
        System.out.println(asd.toString());
        boolean asdd = asd.add(2);
        System.out.println(asdd);
        return memoization[num] = calculateFibonacci(num - 1) + calculateFibonacci(num - 2);
    }
}