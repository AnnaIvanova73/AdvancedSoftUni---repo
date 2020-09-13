import java.io.*;

public class E1_SumLines {
    public static void main(String[] args) throws FileNotFoundException {


        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\FilesStreams\\Exercise\\" +
                    "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));

            FileWriter writer = new FileWriter("outputSum.txt");

            String line = "";
            while ((line = reader.readLine()) != null) {
                long sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    long num = line.charAt(i);
                    sum += num;
                }

                writer.write(sum + "\n");
                writer.flush();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
