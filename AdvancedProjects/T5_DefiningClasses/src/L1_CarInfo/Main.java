package L1_CarInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCars = Integer.parseInt(reader.readLine());

        ArrayDeque<Car> carData = new ArrayDeque<>();
        while(countCars -- > 0){

            String[] tokens = reader.readLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carData.offer(car);
        }

        for (Car car : carData) {
            System.out.println(car.carInfo(car));
        }
    }
}
