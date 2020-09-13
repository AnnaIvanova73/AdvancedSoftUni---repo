package E9_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;

        Set<Cats> catsSet = new LinkedHashSet<>();
        while (!(line = reader.readLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double characteristics = Double.parseDouble(tokens[2]);

            Cats cats = new Cats(name, type, characteristics);
            catsSet.add(cats);

        }

        line = reader.readLine();

        for (Cats cats : catsSet) {
            if (cats.getName().equals(line)) {
                System.out.println(String.format("%s %s %.2f", cats.getType(), cats.getName(), cats.getCharacteristics()));
            }
        }

    }
}
