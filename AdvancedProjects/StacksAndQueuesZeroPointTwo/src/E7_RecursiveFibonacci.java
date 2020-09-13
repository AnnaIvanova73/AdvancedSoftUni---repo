import java.util.Scanner;

public class E7_RecursiveFibonacci {

    private static long[] memoization;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        memoization = new long[n + 1];

        long fibonacci = calculateFibonacci(n);
        System.out.println(fibonacci);
    }

    private static long calculateFibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        if (memoization[n] != 0) {
            return memoization[n];
        }
            System.out.println(memoization[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2));
        return memoization[n];

    }
}
