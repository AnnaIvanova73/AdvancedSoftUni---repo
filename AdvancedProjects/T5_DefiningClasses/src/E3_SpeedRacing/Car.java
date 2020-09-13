package E3_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distanceTraveled;


    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public boolean canDrive(double amountKm) {
        return this.fuelAmount >= amountKm * fuelCost;
    }


    public void setDistanceTraveled(double amountKm) {
        this.distanceTraveled += amountKm;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setFuelAmount(double amountKm) {
        this.fuelAmount -= amountKm * this.fuelCost;
    }

    public double getFuelAmount(){
        return this.fuelAmount;
    }
}
