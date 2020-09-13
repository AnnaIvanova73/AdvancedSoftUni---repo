import java.io.*;
import java.util.Scanner;

public class Lab2_WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String path = "D:\\FilesStreams\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        StringBuilder result = new StringBuilder();

        try (FileInputStream readFile = new FileInputStream(path)) {
            int oneByte = readFile.read();
            while(oneByte >= 0){
                char symbol = (char)oneByte;
                if(symbol == ',' || symbol ==  '.' || symbol == '!' || symbol =='?'){
                    oneByte = readFile.read();
                    continue;
                }else{
                    result.append(symbol);

                }
                oneByte = readFile.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String string = result.toString();

        OutputStream  outputStream = new FileOutputStream("outputLab.txt");

        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.print(string);

        printWriter.close();

    }
}
