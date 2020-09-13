import java.util.Arrays;
import java.util.Scanner;
public class Lab_Task_1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String parametersFirst = scan.nextLine();
        int limit = 2;
        int[] sizes = takeParameters(parametersFirst,limit);
        int rows = sizes[0];
        int cols= sizes[1];

        int[][] firstMatrix = new int[rows][];
        for (int i = 0; i <rows ; i++) {
            String elementsInnerMatrix = scan.nextLine();
            int[] innerMatrix = takeParameters(elementsInnerMatrix,cols);
            firstMatrix[i] = innerMatrix;
        }

        String parametersSecond = scan.nextLine();
        int[] sizesSecond = takeParameters(parametersSecond,limit);
        rows = sizesSecond[0];
        cols= sizesSecond[1];

        int[][] secondMatrix = new int[rows][];
        for (int i = 0; i <rows ; i++) {
            String elementsInnerMatrix = scan.nextLine();
            int[] innerMatrix = takeParameters(elementsInnerMatrix,cols);
            secondMatrix[i] = innerMatrix;
        }

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
            int[] innerOfFirst = firstMatrix[rows];
            int[] innerOfSecond = secondMatrix[rows];
            if(innerOfFirst.length != innerOfSecond.length){
                return false;
            }
            for (int cols = 0; cols < innerOfFirst.length ; cols++) {
                int something = innerOfFirst[cols];
                int somethingEls = innerOfSecond[cols];
                if(innerOfFirst[cols] != innerOfSecond[cols]){
                    return false;
                }
            }
        }
        return true;
    }
    private static int[] takeParameters(String string,int limit) {
        return Arrays.stream(string.split("\\s+"))
                .limit(limit)
                .mapToInt(Integer::parseInt).toArray();
    }
}
