package E3_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(reader.readLine());


        Set<Car> carData = new LinkedHashSet<>();

        for (int i = 0; i < counter; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);

            Car car = new Car(name, fuelAmount, fuelCost);
            carData.add(car);
        }

        String line = "";


        StringBuilder print = new StringBuilder();
        while (!(line = reader.readLine()).equalsIgnoreCase("end")) {

            String[] tokens = line.split("\\s+");
            String name = tokens[1];
            double amountKm = Double.parseDouble(tokens[2]);

            for (Car car : carData) {
                if (car.getModel().equals(name)) {
                    if (car.canDrive(amountKm)) {
                        car.setDistanceTraveled(amountKm);
                        car.setFuelAmount(amountKm);
                    } else {
                        print.append("Insufficient fuel for the drive").append(System.lineSeparator());
                    }
                }
            }
        }

        carData.forEach(a -> {
            print.append(String.format("%s %.2f %.0f%n", a.getModel(), a.getFuelAmount(), a.getDistanceTraveled()));
        });
        System.out.println(print.toString());
    }
}
