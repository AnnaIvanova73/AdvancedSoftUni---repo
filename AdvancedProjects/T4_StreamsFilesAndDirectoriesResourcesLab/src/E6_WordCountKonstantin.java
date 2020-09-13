import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E6_WordCountKonstantin {
    public static void main(String[] args) {


        Map<String,Integer> wordsAndCount = new HashMap<>();
        try{
            FileWriter fileWriter = new FileWriter("out.txt");
            List<String> strings = Files.readAllLines(Path.of("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt"));
            List<String> target = Files.readAllLines(Path.of("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt"));

            String[] text = target.get(0).replaceAll(",.","").split("\\s+");

            for (String word : strings.get(0).split("\\s+")) {
                wordsAndCount.putIfAbsent(word,0);

                for (String targetWord : text) {

                    if(word.equals(targetWord)){
                        int count = wordsAndCount.get(word) + 1;
                        wordsAndCount.put(word,count);
                    }
                }
            }

            wordsAndCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(k->{
                String result = String.format("%s - %d%n",k.getKey(),k.getValue());

                try {
                    fileWriter.write(result);
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.print(result);

            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
