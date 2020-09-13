import java.util.Scanner;

public class Exercise_Task_1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix;

        if("A".equals(pattern)){
            matrix = generateFirstPattern(size);
        }else{
            matrix = generateSecondPattern(size);
        }

        printMatrix (matrix);
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder printResult = new StringBuilder();

        for (int[] rows : matrix) {
            printResult.setLength(0);
            for (int col : rows) {
                printResult.append(col).append(" ");
            }
            System.out.println(printResult.toString().trim());
        }
    }

    private static int[][] generateSecondPattern(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < size ; row++) {
                    matrix[row][col] = value;
                    value++;
                }
            }else{

                for (int row = size -1; row >= 0; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }

        }

        return matrix;
    }

    private static int[][] generateFirstPattern(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size ; row++) {
                matrix[row][col] = value;
                value++;
            }
        }

        return matrix;
    }
}
