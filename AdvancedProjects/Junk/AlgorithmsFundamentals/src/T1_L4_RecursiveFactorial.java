import java.util.Scanner;

public class T1_L4_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long number = scan.nextInt();

        long factorial = calculateFacturial(number);

        System.out.println(factorial);
    }

    private static long calculateFacturial(long number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFacturial(number - 1);
    }
}
