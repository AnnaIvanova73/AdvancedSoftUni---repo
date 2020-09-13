import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class L6_SortLines {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("inputLab.txt");

        FileWriter writer = new FileWriter("aSDF.txt");


        List<String> lines;
        try {
            lines = Files.readAllLines(inPath);
            Collections.sort(lines);

            for (String line : lines) {
                if(line.length() >= 1){
                    writer.write(line + System.lineSeparator());
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
