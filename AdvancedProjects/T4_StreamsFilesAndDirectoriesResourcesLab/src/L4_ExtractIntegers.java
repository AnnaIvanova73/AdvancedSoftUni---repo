import java.io.*;
import java.util.Scanner;

public class L4_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        File file = new File("inputLab.txt");

        Scanner scan = new Scanner(file);

        PrintWriter writer = new PrintWriter("integer.txt");

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int nextInt = scan.nextInt();
                writer.println(nextInt);
            } else {
                scan.next();
            }

        }
        writer.flush();
    }
}
