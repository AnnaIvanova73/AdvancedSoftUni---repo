import java.io.File;

public class L7_ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\Advanced\\T4_StreamsFilesAndDirectoriesResourcesLab\\Files-and-Streams");

        File[] files = file.listFiles();

        assert files != null;
        for (File file1 : files) {

            if (!file1.isDirectory()) {
                System.out.printf("%s: [%d]%n", file1.getName(), file1.length());
            }
        }
    }
}
