import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L1_ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = "";
        while(!"END".equals(input = scan.nextLine())){
            String[] tokens = input.split(", ");

            if(tokens[0].equals("IN")){
                parking.add(tokens[1]);
            }else{
                parking.remove(tokens[1]);
            }
        }

        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }

        for (String s : parking) {
            System.out.println(s);
        };
    }
}
