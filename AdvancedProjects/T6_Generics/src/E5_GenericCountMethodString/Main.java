package E5_GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countLines = Integer.parseInt(reader.readLine());

        E5_GenericCountMethodString.Box<String> box = new Box<>();
        while(countLines-- > 0){
            String currentLine = reader.readLine();
            box.addElement(currentLine);
        }

        String elementCompareWith = reader.readLine();
        System.out.println(box.getCountOfGreaterElements(elementCompareWith));
    }
}
