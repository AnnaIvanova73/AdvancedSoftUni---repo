import java.util.Arrays;
import java.util.Scanner;

public class T1_L1_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = recursionSumArray(arr,0);

        System.out.println(sum);
    }

    private static int recursionSumArray(int[] arr, int i) {
        if(i >= arr.length){
            return 0;
        }

       return arr[i] + recursionSumArray(arr,i + 1);
    }
}
