import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L6_SortLines1 {
    public static void main(String[] args) throws IOException {
        String fileName = "inputLab.txt";

        List<String> collect = Files.readAllLines(Paths.get(fileName))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("sorted-lines.txt"),collect);

// ------------
        Path path = Paths.get("inputLab.txt");
        Path output = Paths.get("sorted-output.txt");

        try{
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream().filter(a -> !a.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output,lines);
        }catch (IOException e) {
            e.printStackTrace();
        }



    }
}
