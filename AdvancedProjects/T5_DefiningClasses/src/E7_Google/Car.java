package E7_Google;

public class Car {
    private String carModel;
    private double carSpeed;

    public Car (String carModel, double carSpeed){
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public double getCarSpeed() {
        return this.carSpeed;
    }

}
