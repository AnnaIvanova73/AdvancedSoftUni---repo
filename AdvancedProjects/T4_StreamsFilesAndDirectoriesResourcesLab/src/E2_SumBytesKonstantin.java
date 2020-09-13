import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E2_SumBytesKonstantin {
    public static void main(String[] args) {

        List<String> strings;

        try{
            FileWriter fileWriter = new FileWriter("outBytesKonstantin");
            strings = Files.readAllLines(Path.of("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));

            long asciiSum = 0;
            for (String string : strings) {

                for (int i = 0; i < string.length(); i++) {
                    asciiSum += string.charAt(i);
                }
                
            }

            fileWriter.write(asciiSum + "\n");
            fileWriter.flush();
            System.out.println(asciiSum);

            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
