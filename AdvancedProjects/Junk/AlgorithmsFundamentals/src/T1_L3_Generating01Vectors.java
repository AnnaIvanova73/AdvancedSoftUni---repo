import java.util.Arrays;
import java.util.Scanner;
public class T1_L3_Generating01Vectors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int combinations = Integer.parseInt(scan.nextLine());

        int[] vector = new int[combinations];


        generateVecotr(0,vector);

    }

    private static void generateVecotr(int index, int[] vector) {
        if(index >= vector.length){
          printVector(vector);
        }else{
            for (int i = 0; i <=1 ; i++) {
                vector[index] =i;
                generateVecotr(index + 1,vector);
            }
            
        }
    }

    private static void printVector(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("[\\[\\], ]",""));
    }
}
