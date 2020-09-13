import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E5_PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String input = "";
        while (!"search".equals(input = scan.nextLine())) {
            String[] namesAndNumbers = input.split("-");

            String name = namesAndNumbers[0];
            String number = namesAndNumbers[1];

            phoneBook.putIfAbsent(name, number);
            phoneBook.put(name, number);
        }

        StringBuilder finderNames = new StringBuilder();
        while (!"stop".equals(input = scan.nextLine())) {

            if (phoneBook.containsKey(input)) {
                finderNames.append(String.format("%s -> %s", input, phoneBook.get(input))).append("\r\n");

            } else {
                finderNames.append(String.format("Contact %s does not exist.", input)).append("\r\n");
            }


        }

        System.out.println(finderNames);
    }
}
