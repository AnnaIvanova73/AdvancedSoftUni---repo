package L2_Constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCars = Integer.parseInt(reader.readLine());

        ArrayDeque<Car> carData = new ArrayDeque<>();
        while (countCars-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            int length = tokens.length;

            Car car;
            switch (length) {
                case 1:
                    car = new Car(tokens[0]);
                    break;
                case 2:
                    car = new Car(tokens[0], tokens[1]);
                    break;
                case 3:
                    car = new Car(tokens[0],
                            tokens[1], Integer.parseInt(tokens[2]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + length);
            }
            carData.offer(car);
        }
        for (Car carCr : carData) {
            System.out.println(carCr.carInfo());
        }
    }
}
