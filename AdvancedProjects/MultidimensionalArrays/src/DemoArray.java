import java.util.Arrays;
import java.util.Scanner;

public class DemoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr));


        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, n);

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int num = n - 1 - i;
            System.out.print(matrix[n - 1 - i][i] + " ");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        String line;
        String[] split;
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            split = line.trim().split("\\s+");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        return matrix;
    }
}
//        int asf = 30 / 11;
//        System.out.println(asf);
//        asf *= 6 +5;
//        System.out.println(asf);
//        int asd = 20 % 9;
//        System.out.println(asd);
//        asd*= 4 + 5;
//        System.out.println(asd);
//
//        System.out.println(Math.ceil(asd /= 3));
//        System.out.println(Math.ceil(asf /= 3));

// System.out.println(134% 3);
