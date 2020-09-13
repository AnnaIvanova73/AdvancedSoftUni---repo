import java.util.Arrays;
import java.util.Scanner;
public class Lab_Task_4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        String[] tokens = scan.nextLine().split(", +");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        result.append(rows).append(System.lineSeparator()).append(cols).append(System.lineSeparator());

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            String input = scan.nextLine().replace(", ", " ");
            int[] innerArray = Arrays.stream(input.split(" ")).limit(cols)
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }

        int sum = 0;
        for (int[] array : matrix) {
            int sumRow = Arrays.stream(array).sum();
            sum+=sumRow;
        }
        result.append(sum);

        System.out.println(result.toString());
    }
}
