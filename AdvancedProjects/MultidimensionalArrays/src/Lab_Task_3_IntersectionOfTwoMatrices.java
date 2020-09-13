import java.util.Scanner;
public class Lab_Task_3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] first = readAndPutInMatrix(scan, rows, cols);

        char[][] second = readAndPutInMatrix(scan, rows, cols);

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < first.length ; row++) {
            for (int col = 0; col < first[row].length; col++) {
                if(first[row][col] != second[row][col]){
                    result.append('*').append(" ");
                }else{
                    result.append(first[row][col]).append(" ");
                }
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result.toString().trim());
    }

    private static char[][] readAndPutInMatrix(Scanner scan, int rows, int cols) {
        char[][] matrix = new char[rows][];
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine().replace(" ", "");
            input = input.substring(0, cols);
            char[] innerMatrix = input.toCharArray();
            matrix[i] = innerMatrix;
        }
        return matrix;
    }
}
