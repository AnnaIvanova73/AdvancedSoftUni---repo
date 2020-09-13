package E5_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Set<Engine> storeEngines = new HashSet<>();
        Set<Car> storeCars = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            String power = input[1];

            Engine engine = createInstance(input, model, power);

            storeEngines.add(engine);
        }
        
        count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split("\\s+");
            String carModel = input[0];
            String engine = input[1];
            int weight;
            String colour;
            Engine engine1 = null ;

            for (Engine storeEngine : storeEngines) {
                if(storeEngine.getModel().equals(engine)){
                    engine1 = storeEngine;
                    break;
                }
            }

            Car car;
            switch (input.length) {
                case 2:
                    car = new Car(carModel, engine1);
                    break;
                case 3:
                    try {
                        weight = Integer.parseInt(input[2]);
                        car = new Car(carModel,engine1,weight);
                    } catch (NumberFormatException e) {
                        colour = input[2];
                        car = new Car(carModel,engine1,colour);
                    }
                    break;
                default:
                    weight = Integer.parseInt(input[2]);
                    car = new Car(carModel,engine1,weight,input[3]);
                    break;
            }

                storeCars.add(car);
        }

        for (Car storeCar : storeCars) {
            System.out.println(storeCar.toString());
        }

    }

    private static Engine createInstance (String[] input, String model, String power) {
        Engine engine;
        int displacement;
        String efficiency;
        switch (input.length) {
            case 2:
                engine = new Engine(model, power);
                break;
            case 3:
                try {
                    displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model,power,displacement);
                } catch (NumberFormatException e) {
                    efficiency = input[2];
                    engine = new Engine(model,power,efficiency);
                }
                break;
            default:
                displacement = Integer.parseInt(input[2]);
                engine = new Engine(model,power,displacement,input[3]);
                break;
        }
        return engine;
    }
}
