import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2_WriteToFileMarto {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\FilesStreams\\Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileInputStream inputStream = new FileInputStream(file);

        Scanner scan = new Scanner(inputStream);

        StringBuilder builder = new StringBuilder();

        String line = scan.nextLine();

        while (line != null){

            builder.append(line.replaceAll("[,.!?]",""))
                    .append(System.lineSeparator());

            try{
                line = scan.nextLine();
            }catch (NoSuchElementException ex){
                inputStream.close();
                break;
            }

        }

        String result = builder.toString();

        OutputStream outputStream = new FileOutputStream("outputLab1.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        writer.print(result);

        writer.flush();

    }
}
