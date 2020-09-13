import java.io.*;

public class L5_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("inputLab.txt"));

        PrintWriter out = new PrintWriter(new FileWriter("outputPath.txt"));

        String line = "";

        int counter = 1;
        while((line = in.readLine()) != null){

            if(counter % 3 == 0){
                out.println(line);
            }

            counter++;
        }

        out.flush();


//        try (BufferedReader in = new BufferedReader(new FileReader("inputLab.txt"))){
//            PrintWriter out = new PrintWriter(new FileWriter("outputPath2.txt"));
//            int counter = 1;
//            String line = in.readLine();
//            while(line !=null){
//                if (counter % 3 == 0) {
//                    out.println(line);
//                }
//                counter++;
//                line = in.readLine();
//            }
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
