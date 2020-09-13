import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Lab1_ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "inputLab.txt";

        try(FileInputStream fileInputStream = new FileInputStream(path)){ // четем по байтове
            int oneByte = fileInputStream.read();
            while(oneByte >= 0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read(); // връща -1 ако е празен
            }

        }catch (IOException e){
                e.printStackTrace();
        }

    }
}
