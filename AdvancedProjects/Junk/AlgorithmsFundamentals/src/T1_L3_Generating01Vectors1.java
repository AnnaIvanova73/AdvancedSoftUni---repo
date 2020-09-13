import java.util.Arrays;
import java.util.Scanner;

public class T1_L3_Generating01Vectors1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int combinations = Integer.parseInt(scan.nextLine());

        int[] vector = new int[combinations];


        generateVecotr(0, vector);

    }

    private static void generateVecotr(int i, int[] vector) {
        if (i >= vector.length) {
            printVector(vector);
            return;
        }
        for (int j = 0; j <= 1; j++) {
            vector[i] = j;
            generateVecotr(i + 1, vector);
        }
    }


    private static void printVector(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("[\\[\\], ]", ""));
    }
}
