import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E2_SumBytes {
    public static void main(String[] args) {

        try{
            FileWriter writer = new FileWriter("outSumBytes.txt");
            BufferedReader reader = new BufferedReader(new FileReader("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));

            String line = "";
            long sum = 0;
            while((line = reader.readLine()) != null){

                for (int i = 0; i < line.length(); i++) {
                    int asciiNum = line.charAt(i);
                    sum += asciiNum;
                }
            }
            writer.write(String.valueOf(sum));
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
