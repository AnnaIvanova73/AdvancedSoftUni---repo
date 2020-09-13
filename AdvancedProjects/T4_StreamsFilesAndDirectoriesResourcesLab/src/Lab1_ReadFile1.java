import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Lab1_ReadFile1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Path path = Path.of("D:\\Advanced\\input.txt");
        File file = new File("inputLab.txt");
        byte[] bytes = Files.readAllBytes(path);

        for (byte currByte : bytes) {
            System.out.print(Integer.toBinaryString(currByte) + " ");
        }
    }
}
