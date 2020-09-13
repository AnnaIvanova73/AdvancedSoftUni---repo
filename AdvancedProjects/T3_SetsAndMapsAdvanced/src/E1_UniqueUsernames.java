import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E1_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int usernamesCount = Integer.parseInt(scan.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        while(usernamesCount-- > 0){
            usernames.add(scan.nextLine());
        }

        usernames.forEach(System.out::println);
    }
}
