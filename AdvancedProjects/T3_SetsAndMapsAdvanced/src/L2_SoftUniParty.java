import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String guests = "";

        while (!"PARTY".equals(guests = scan.nextLine())) {
            char symbol = guests.charAt(0);

            if (Character.isDigit(symbol)) {
                vip.add(guests);
            } else {
                regular.add(guests);
            }
        }

        while (!"END".equals(guests = scan.nextLine())) {
            regular.remove(guests);
            vip.remove(guests);
        }

        System.out.println(vip.size() + regular.size());
        for (String g : vip) {
            System.out.println(g);
        }
        for (String g : regular) {
            System.out.println(g);
        }
    }
}