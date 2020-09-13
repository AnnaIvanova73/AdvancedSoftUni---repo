import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E3_AllCapitals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try{
            FileWriter writer = new FileWriter("outAllCapitals.txt");
            BufferedReader reader = new BufferedReader(new FileReader("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));

            String line = "";
            while((line = reader.readLine()) != null){
                writer.write(line.toUpperCase() + "\n");
                writer.flush();
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
