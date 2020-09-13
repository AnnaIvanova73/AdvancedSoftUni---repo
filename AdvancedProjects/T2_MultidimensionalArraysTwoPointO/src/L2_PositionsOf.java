import java.util.Arrays;
import java.util.Scanner;

public class L2_PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = readArray(scan,"\\s+");

        int[][] matrix = readMatrix(scan,input[0],input[1],"\\s+");

        int number = Integer.parseInt(scan.nextLine());

        StringBuilder result = findPositionOfNumberInMatrix(matrix,number);

        if(result.length() > 0){
            System.out.println(result);
        }else{
            System.out.println("not found");
        }

    }

    private static StringBuilder findPositionOfNumberInMatrix(int[][] matrix, int number) {
        StringBuilder positions = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(number == matrix[row][col]){
                    positions.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }
        return positions;
    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = readArray(scan, pattern);
            matrix[row] = array;
        }

        return matrix;
    }
    private static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
