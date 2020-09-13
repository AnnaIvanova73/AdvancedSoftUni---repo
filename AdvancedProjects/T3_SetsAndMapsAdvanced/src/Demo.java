import java.io.File;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        File file = new File ("C:\\Program Files");

        System.out.println(file.getUsableSpace());
    }
}
