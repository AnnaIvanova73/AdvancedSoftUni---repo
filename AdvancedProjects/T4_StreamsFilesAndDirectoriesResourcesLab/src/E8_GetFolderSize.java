import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class E8_GetFolderSize {
    public static void main(String[] args) {


        try{
            FileWriter fileWriter = new FileWriter(new File("output.txt"));
            File[] file = new File("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources").listFiles();

            long sum = 0;
            assert file != null;
            for (File file1 : file) {
                System.out.println(file1.length());
                sum+=file1.length();
            }

           fileWriter.write("Folder size: " + sum);
            fileWriter.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
