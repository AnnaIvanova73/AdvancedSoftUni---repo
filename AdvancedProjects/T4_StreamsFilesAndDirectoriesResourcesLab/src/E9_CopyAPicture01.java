import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E9_CopyAPicture01 {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(new File("D:\\FilesStreams\\Exercise\\cosmo.jpg"));
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\local.jpg"));

        byte[] buffer = new byte[1024];

        int read = 0;

        while((read = inputStream.read(buffer)) > 0){
            outputStream.write(buffer,0,read);
        }

    }
}
