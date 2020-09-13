import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E4_CountCharacterTypes {
    public static void main(String[] args) {

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;

        try{
            String file = String.join("", Files.readAllLines(Path.of("D:\\FilesStreams\\Exercise" +
                    "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt")));

            String lookPunc = "!,.?";
            String vowels = "aeiou";

            for (int i = 0; i < file.length(); i++) {
                char symbol = file.charAt(i);

                if(vowels.contains(String.valueOf(symbol))){
                    countVowels+=1;
                }else if(lookPunc.contains(String.valueOf(symbol))){
                    countPunctuation +=1;
                }else if(symbol != 32){
                    countConsonants +=1;
                }
            }

            FileWriter fileWriter = new FileWriter("outCharacterCountTypes");
            fileWriter.write(String.format("Vowels: %d\n" + "Consonants: %d\n" +
                    "Punctuation: %d",countVowels,countConsonants,countPunctuation));

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
