import java.util.Arrays;
import java.util.Scanner;

public class Lab_Task_1_CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        int [][] firstMatrix = createMatrix(scan, rows, cols);

        rows=scan.nextInt();
        cols=scan.nextInt();
        scan.nextLine();
        int[][] secondMatrix = createMatrix(scan,rows,cols);


        if(areEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }

    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        for (int rows = 0; rows <firstMatrix.length ; rows++) {
            if(firstMatrix[rows].length != secondMatrix[rows].length){
                return false;
            }else{
                for (int columns = 0; columns < firstMatrix[rows].length ; columns++) {
                    if(firstMatrix[rows][columns] != secondMatrix[rows][columns]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[][] createMatrix(Scanner scan, int rows, int cols) {

        int[][] matrix = new int[rows][];
        for (int i = 0; i <rows ; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).limit(cols)
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i]=numbers;
        }
        return matrix;
    }
}
