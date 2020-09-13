import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E1_SumLinesKonstantin {
    public static void main(String[] args) {

        try{
            //FileWriter writer = new FileWriter(new File ("out.txt"));

            FileWriter fileWriter = new FileWriter("out.txt");
            List<String> strings = Files.readAllLines(Path.of("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));


            for (String string : strings) {
                long asciiSum = 0;

                for (int i = 0; i < string.length(); i++) {
                    asciiSum += string.charAt(i);
                }

                System.out.println(asciiSum);
                fileWriter.write(asciiSum + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

     //   File file = new File("");
    }
}
