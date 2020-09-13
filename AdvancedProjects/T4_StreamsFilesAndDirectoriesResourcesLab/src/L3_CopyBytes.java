import java.io.*;
import java.nio.file.Files;

public class L3_CopyBytes {
    public static void main(String[] args) throws IOException {
        // BufferedReader in =  new BufferedReader(new FileReader("inputLab.txt"));

        File file = new File("inputLab.txt");

        byte[] bytes = Files.readAllBytes(file.toPath());

        Writer writer = new FileWriter("outputBytes.txt");
        OutputStream result = new FileOutputStream("outBytes1.txt");
        for (byte b : bytes) {
            String outSymbol = String.valueOf(b);

            if (b == 32) {
                outSymbol = " ";
                result.write(b);

            } else if (b == 10) {
                outSymbol = System.lineSeparator();
                result.write(b);
            } else {
                for (int i = 0; i < outSymbol.length(); i++) {
                    result.write(outSymbol.charAt(i));
                }
            }

            writer.write(outSymbol);

        }
        writer.flush();
    }
}
