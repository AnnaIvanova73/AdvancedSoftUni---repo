import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab3_CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {

        Path path = Paths.get("inputLab.txt");


        try(InputStream inputStream = new FileInputStream(String.valueOf(path))) {
            OutputStream out = new FileOutputStream("outputByte.txt");

            int oneByte = 0;
            while((oneByte = inputStream.read()) >= 0){
                if(oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
                }else{
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        char wtf = digits.charAt(i);
                        out.write(wtf);
                    }
                }
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
