import java.io.*;

public class E9_CopyAPicture02 {
    public static void main(String[] args) throws IOException {

        String path = "D:\\local.jpg";

        FileInputStream inputStream = new FileInputStream(path);

        byte[] image = inputStream.readAllBytes();

        FileOutputStream outputStream = new FileOutputStream("D:\\second - copy.jpg");

        outputStream.write(image);
        outputStream.close();
    }
}
