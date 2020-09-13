import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class E6_WordCount {
    public static void main(String[] args) {

        try {
            String lineOfText = String.join("", Files.readAllLines(Path.of("D:\\Advanced\\" +
                    "T4_StreamsFilesAndDirectoriesResourcesLab\\src\\resources\\text.txt")));

            String[] textArr
                    = lineOfText.replaceAll("[,.]", "").split("\\s+");
            List<String> textAxList = Arrays.asList(textArr);


            List<String> words = Files.readAllLines(Path.of("D:\\Advanced\\" +
                    "T4_StreamsFilesAndDirectoriesResourcesLab\\src\\resources\\words.txt"));
            String[] split = words.get(0).replaceAll("[,.]", "").split("\\s+");


            Map<String, Integer> result = new HashMap<>();
            for (String currWord : split) {
                int freq = Collections.frequency(textAxList, currWord);
                result.put(currWord, freq);
            }
            result.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(a -> {
                System.out.println(a.getKey() + " - " + a.getValue());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
