package E6_GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double countLines = Double.parseDouble(reader.readLine());

        Box<Double> box = new Box<>();
        while (countLines-- > 0) {
            double currentLine = Double.parseDouble(reader.readLine());
            box.addElement(currentLine);
        }

        double elementCompareWith = Double.parseDouble(reader.readLine());
        System.out.println(box.getCountOfGreaterElements(elementCompareWith));
    }
}
