import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(new FileInputStream("inputLab.txt"));
//
//        String input = scan.nextLine();
//        System.out.println(input);

       // ---------------

        List<String> strings = Files.readAllLines(Paths.get("inputLab.txt"));//лист, със стреам или обхождане в друго

        byte[] strings1 = Files.readAllBytes(Paths.get("inputLab.txt"));// или ги четем, като байтове

        for (String string : strings) {
            System.out.println(string);
        }

       // --------------

        FileInputStream inputStream = new FileInputStream("inputLab.txt");
        int result = inputStream.read();
        String str= "";

        while(result>0){

            System.out.println(result); //принтираме стойността на байтовете, ако кастенм към char ще си прочета чаровете
            // str+= (char)result;

            result = inputStream.read();
        }

       // -----------------

        Path path = Path.of("D:\\Advanced\\inputLab.txt");
        System.out.println(path.isAbsolute()); //true

        Path path1 = Path.of("D:inputLab.txt");
        System.out.println(path.isAbsolute()); //false


        // ---------------

//        String output;
//
//        try{
//            FileInputStream inputStream1 = new FileInputStream("inputLab.txt");
//            output = "File found";
//        }catch (FileNotFoundException ex){
//            output = "File not found";
//        }
//
//        System.out.println(output);

        // ---------------

        String output;

        FileInputStream inputStream1;
        try{
            inputStream1 = new FileInputStream("inputLab.txt");
            output = "File found";
        }catch (Exception ex){
            output = "File not found";
        }finally {
            inputStream.close();
        }

        System.out.println(output);



        //File f = new File("D:\\Advanced\\T4_StreamsFilesAndDirectoriesResourcesLab\\Files-and-Streams");
        InputStream f1 = new FileInputStream("D:\\FilesStreams\\Lab\\04. " +
                "Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt"); // няма да работи с папка? Защоь
        int sm = f1.available();
        System.out.println(sm);


    }
}
