import java.util.Arrays;
import java.util.Scanner;

public class T1_L1_RecursiveArraySum1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = recursionSumArrayElements(arr,arr.length - 1);

        System.out.println(sum);
    }

    private static int recursionSumArrayElements(int[] arr, int i) {
        if(i < 0){
            return 0;
        }

        return arr[i] + recursionSumArrayElements(arr,i - 1);// рекурсивно преизвикване на рекурсия
    }
}
