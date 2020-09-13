import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E12_CreateZipArchive {
    public static void main(String[] args) throws IOException {

        String filesPath = "Desktop\\url";

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("zip.zip"));

        FileInputStream fileInputStream = new FileInputStream("inputLab.txt");


        zipOutputStream.putNextEntry(new ZipEntry("inputLab.txt"));

        zipOutputStream.write(fileInputStream.readAllBytes());

        zipOutputStream.close();

    }
}
