import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E7_MergeTwoFiles {
    public static void main(String[] args) {

        try{
            FileWriter fileWriter = new FileWriter(new File("output1.txt"));
            List<String> fileOne = Files.readAllLines(Path.of("D:\\Advanced\\" +
                    "T4_StreamsFilesAndDirectoriesResourcesLab\\src\\resources\\inputOne.txt" ));

            List<String> fileTwo = Files.readAllLines(Path.of("D:\\Advanced\\" +
                    "T4_StreamsFilesAndDirectoriesResourcesLab\\src\\resources\\inputTwo.txt" ));


            for (String file : fileOne) {
                fileWriter.write(file + System.lineSeparator());
                fileWriter.flush();
            }


            for (String file : fileTwo) {
                fileWriter.write(file + System.lineSeparator());
                fileWriter.flush();
            }

        }catch (IOException ignored){

        }
    }
}
