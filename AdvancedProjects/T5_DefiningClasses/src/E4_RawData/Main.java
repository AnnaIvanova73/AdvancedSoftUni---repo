package E4_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countLines = Integer.parseInt(reader.readLine());

        Set<Car> carData = new LinkedHashSet<>();

        for (int i = 0; i < countLines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double firstPr = Double.parseDouble(tokens[5]);
            int firstAge = Integer.parseInt(tokens[6]);
            double secondPr = Double.parseDouble(tokens[7]);
            int secondAge = Integer.parseInt(tokens[8]);
            double thirdPr = Double.parseDouble(tokens[9]);
            int thirdAge = Integer.parseInt(tokens[10]);
            double fourthPr = Double.parseDouble(tokens[11]);
            int fourthAge = Integer.parseInt(tokens[12]);

            Tires tires = new Tires(firstPr, firstAge, secondPr, secondAge, thirdPr, thirdAge, fourthPr, fourthAge);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engineSpeed, enginePower);
            Car car = new Car(model, engine, cargo, tires);
            carData.add(car);
        }


        String typeCargo = reader.readLine();

        StringBuilder print;
        if (typeCargo.equals("fragile")) {
            print = getFragileType(carData);
        } else {
            print = getFlamableType(carData);
        }

        System.out.println(print.toString());
    }

    private static StringBuilder getFlamableType(Set<Car> carData) {
        StringBuilder result = new StringBuilder();
        for (Car car : carData) {
            if (car.getCargoClass().getType().equals("flamable") && car.getEngineClass().getEnginePower() > 250) {
                result.append(car.getModel()).append(System.lineSeparator());
            }
        }

        return result;
    }

    private static StringBuilder getFragileType(Set<Car> carData) {
        StringBuilder result = new StringBuilder();

        for (Car car : carData) {
            if (car.getCargoClass().getType().equals("fragile")) {
                Tires tires = car.getTiresClass();
                if (tires.getFirstPressure() < 1 || tires.getSecondPressure() < 1
                        || tires.getThirdPressure() < 1 || tires.getFourthPressure() < 1) {
                    result.append(car.getModel()).append(System.lineSeparator());
                }
            }
        }
        return result;
    }
}
